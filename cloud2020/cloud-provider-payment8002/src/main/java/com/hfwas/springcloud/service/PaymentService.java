package com.hfwas.springcloud.service;

import com.hfwas.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author HFwas
 * @Date 2021/11/14 19:18
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
