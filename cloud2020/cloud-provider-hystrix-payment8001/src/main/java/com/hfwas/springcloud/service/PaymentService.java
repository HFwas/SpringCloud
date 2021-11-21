package com.hfwas.springcloud.service;

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

    public String paymentInfo_TimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "线程池： " + Thread.currentThread().getName() + "paymentInfo_TimeOut,id= " + "\t" + id;
    }

}
