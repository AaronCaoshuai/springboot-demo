package com.aaron.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @RequestMapping("/hello")
    public String hello(){
        return "hello SpringBoot";
    }

    @RequestMapping("/customException")
    public String customException(){
        System.out.println(1/0);
        return "hello SpringBoot";
    }

}
