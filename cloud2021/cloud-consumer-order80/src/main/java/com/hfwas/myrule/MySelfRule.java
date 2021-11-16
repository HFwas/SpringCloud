package com.hfwas.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author HFwas
 * @Date 2021/11/16 23:58
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule iRule(){
        // 定义为随机
        return new RandomRule();
    }

}
