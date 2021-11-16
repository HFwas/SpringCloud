package com.hfwas.springcloud.controller;

import com.hfwas.springcloud.entities.CommonResult;
import com.hfwas.springcloud.entities.Payment;
import com.hfwas.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        services.stream().forEach(System.out::println);

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        List<String> collect = instances.stream().map(instance -> instance.getInstanceId() + ":" + instance.getHost() + ":" + instance.getServiceId() + ":" + instance.getPort()).collect(Collectors.toList());
        return collect;
    }
}
