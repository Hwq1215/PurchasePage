package com.example.purchasepage.controller;

import com.example.purchasepage.pojo.RetResult;
import com.example.purchasepage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    UserService userService = new UserService();

    @PostMapping("login/in")
    public RetResult loginIn(Integer userId, String password){
        RetResult result = null;
        switch (userService.checkUser(userId,password)){
                case 200:
                    result = new RetResult(200,"user exist and password correct",userService.getUserByIdByPassword(userId,password));
                    System.out.println("userId " + userId + " login in");
                    break;
                case 402:
                    result = new RetResult(402,"user exist but password incorrect",null);
                    break;
                case 403:
                    result = new RetResult(403,"user no exist",null);
                    break;
            default:break;    
        }
        return result;
    }
}
