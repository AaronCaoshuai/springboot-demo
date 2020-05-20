package com.aaron.service;

import com.aaron.SpringbootBasicApplicationTests;
import com.aaron.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义用户测试
 */
public class HelloServiceTest extends SpringbootBasicApplicationTests {


    @Autowired
    private HelloService helloService;

    @Test
    public void insertUserTest() {
        helloService.insertUser(new User());
    }

}
