package com.aaron.controller;

import com.aaron.domain.User;
import com.aaron.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/save")
    public String saveUser(){
        try{
        User user = new User();
        user.setUsername("张三");
        user.setAddress("123");
        user.setBirthday(new Date().toString());
        user.setSex("123");
        userService.saveUser(user);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

}
