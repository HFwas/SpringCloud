package com.hfwas.springcloud.controller;

import com.hfwas.springcloud.entities.CommonResult;
import com.hfwas.springcloud.entities.Payment;
import com.hfwas.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author HFwas
 * @Date 2021/11/21 15:57
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/feign/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/feign/timeout/consumer/payment/get")
    public CommonResult<String> getPaymentByIdTimeout() {
        return new CommonResult<String>(200,paymentFeignService.paymentTimeOut());
    }

}
