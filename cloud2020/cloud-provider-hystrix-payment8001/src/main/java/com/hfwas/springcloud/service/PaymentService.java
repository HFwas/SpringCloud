package com.hfwas.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

}
