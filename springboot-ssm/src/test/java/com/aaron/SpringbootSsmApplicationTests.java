package com.aaron;

import com.aaron.domain.User;
import com.aaron.mapper.UserMapper;
import com.aaron.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSsmApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        List<User> users = userMapper.selectAll();
        System.out.println(users);
    }

    @Test
    public void transactionTest()  {
        try{
            User user = new User();
            user.setUsername("张三");
            user.setAddress("123");
            user.setBirthday(new Date().toString());
            user.setSex("123");
            userService.saveUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
