package com.aaron.service.impl;

import com.aaron.domain.User;
import com.aaron.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceTest implements HelloService {
    @Override
    public void insertUser(User user) {
        System.out.println("保存用户信息");
    }
}
