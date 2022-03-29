package com.example.purchasepage.service;

import com.example.purchasepage.mapper.ProjectMapper;
import com.example.purchasepage.mapper.UserMapper;
import com.example.purchasepage.pojo.DealingProject;
import com.example.purchasepage.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public int checkUser(Integer userId,String password){
        User user;
        user = userMapper.searchUserByAll(userId, password);
        if(user == null){
            user = userMapper.searchUserById(userId);
            if(user == null){
                return 403;
            }else{
                return 402;
            }
        }else{
            return 200;
        }
    }

    public User getUserByIdByPassword(Integer userId,String password){
        User user;
        user = userMapper.searchUserByAll(userId,password);
        return user;
    }
}
