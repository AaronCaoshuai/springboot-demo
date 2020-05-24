package com.aaron.service.impl;

import com.aaron.service.ProdSendService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProdSendServiceImpl implements ProdSendService {

    @Override
    public void sendMsg() {
        System.out.println("生产发送短信成功");
    }
}
