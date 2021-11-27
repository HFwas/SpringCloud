package com.hfwas.springcloud.controller;

import com.hfwas.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author HFwas
 * @Date 2021/11/27 19:47
 */
@RestController
public class SendMessageController {

    @Autowired
    private IMessageProvider iMessageProvider;

    @GetMapping(value = "/senMessage")
    public String sendMessage() {
        return iMessageProvider.send();
    }

}
