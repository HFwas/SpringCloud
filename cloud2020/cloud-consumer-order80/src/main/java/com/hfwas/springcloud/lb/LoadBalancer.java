package com.hfwas.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author HFwas
 * @Date 2021/11/21 14:51
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> instances);

}
