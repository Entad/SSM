package com.istest.controller;

import com.istest.domain.User;
import com.istest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.DriverManager;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/Usertest")
    public String Usertest(){


        User user = new User();
        user.setName("KDA");
        user.setMoney(2000d);

        userService.saveUser(user);

        return "success";
    }


    @RequestMapping("/transfer")
    public String transfer(){

        userService.transfer("KDA","安妮",100d);

        return "success";
    }


}
