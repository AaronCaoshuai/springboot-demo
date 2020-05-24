package com.aaron.service.impl;

import com.aaron.service.ProdSendService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DevSendServiceImpl implements ProdSendService {

    @Override
    public void sendMsg() {
        System.out.println("开发发送短信成功");
    }
}
