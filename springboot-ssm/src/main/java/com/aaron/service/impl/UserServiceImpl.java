package com.aaron.service.impl;

import com.aaron.domain.User;
import com.aaron.mapper.UserMapper;
import com.aaron.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    @Transactional()//spring默认事务提交方式:发生运行时异常回滚,发生受检查异常提交
    public void saveUser(User user) throws Exception {
        System.out.println("保存用户");
        userMapper.insert(user);
        //运行时异常回滚
        System.out.println(1/0);
       /* if(true){
            throw new Exception("发生受检异常");
        }*/
        userMapper.insert(user);
    }
}
