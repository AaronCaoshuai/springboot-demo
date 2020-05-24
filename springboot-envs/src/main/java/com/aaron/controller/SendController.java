package com.aaron.controller;

import com.aaron.config.Student;
import com.aaron.service.ProdSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class SendController {

    @Autowired
    private ProdSendService sendService;

    //读取配置文件
    @Value("${server.port}")
    private String port;

    @Value("${spring.profiles.active}")
    private String profileActive;

    @Value("${app.name}")
    private String appName;

    @Value("${app.author}")
    private String appAuthor;

    @Autowired
    private Student student;

    @RequestMapping("/msg")
    public String sendMsg(){
        System.out.println("当前环境:"+profileActive+",port:"+port);
        System.out.println("项目名称:"+appName+",appAuthor:"+appAuthor);
        sendService.sendMsg();

        System.out.println(student);
        return "success";
    }
}
