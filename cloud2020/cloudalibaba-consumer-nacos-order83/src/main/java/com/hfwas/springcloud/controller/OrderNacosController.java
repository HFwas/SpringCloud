package com.hfwas.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author HFwas
 * @Date 2021/11/28 19:21
 */
@RestController
public class OrderNacosController {

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String getPaymentInfo(@PathVariable("id") Long id) {
        return restTemplate.getForObject(serviceUrl + "/payment/nacos/" + id, String.class);
    }

}
