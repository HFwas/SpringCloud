package com.hfwas.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author HFwas
 * @Date 2021/11/22 23:10
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService ----  paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService -- paymentInfo_TimeOut";
    }
}
