package com.hfwas.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author HFwas
 * @Date 2021/11/21 17:44
 */
@Service
@Slf4j
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + "paymentInfo_OK,id= " + "\t" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",
            commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public String paymentInfo_TimeOut(Integer id) {
//        int a  = 10 / 0;
        try {
            TimeUnit.SECONDS.sleep(13);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "线程池： " + Thread.currentThread().getName() + "paymentInfo_TimeOut,id= " + "\t" + id;
    }
    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + "8001系统超时，paymentInfo_TimeOutHandler";
    }


    // 服务熔断
    @HystrixCommand(fallbackMethod = "paymentCiruitBreaker_fallback",commandProperties = {
            // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled" , value = "enabled"),
            // 请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
            // 失败率达到多少后跳闸
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000")
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("id，不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }
    public String paymentCiruitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id不能为负数, id = " + id;
    }

}
