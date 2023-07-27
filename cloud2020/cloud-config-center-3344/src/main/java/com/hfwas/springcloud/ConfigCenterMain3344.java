package com.hfwas.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import javax.sound.midi.Soundbank;

/**
 * @Author HFwas
 * @Date 2021/11/26 0:13
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
        String version = SpringBootVersion.getVersion();
        SpringApplication.run(ConfigCenterMain3344.class, args);
    }
}
