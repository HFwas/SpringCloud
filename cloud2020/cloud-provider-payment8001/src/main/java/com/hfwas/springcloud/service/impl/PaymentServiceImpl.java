package com.hfwas.springcloud.service.impl;

import com.hfwas.springcloud.dao.PaymentDao;
import com.hfwas.springcloud.entities.Payment;
import com.hfwas.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author HFwas
 * @Date 2021/11/14 19:19
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
