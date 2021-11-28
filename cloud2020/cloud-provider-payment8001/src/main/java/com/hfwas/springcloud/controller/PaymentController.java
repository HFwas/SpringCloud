package com.hfwas.springcloud.controller;

import com.hfwas.springcloud.entities.CommonResult;
import com.hfwas.springcloud.entities.Payment;
import com.hfwas.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @Author HFwas
 * @Date 2021/11/14 19:21
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/getPayment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (null != payment) {
            return new CommonResult(200,"查询成功,serverPort={}" + serverPort,payment);
        } else {
            return new CommonResult(444,"没有该数据",null);
        }
    }

    @PostMapping("/payment/create")
    public CommonResult creatPayment(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        if (i > 0) {
            return new CommonResult(200, "插入成功" ,i);
        } else {
            return new CommonResult(444,"插入失败",null);
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentTimeOut() {
         try {
             // 暂停几秒钟
             TimeUnit.SECONDS.sleep(3);
         } catch (InterruptedException e) {
             log.error(e.getMessage());
         }
         return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZikpin() {
        return "hi,i`am paymentzipkin server fall back.welcome to hfwas.hahahahahhahahah";
    }
}
