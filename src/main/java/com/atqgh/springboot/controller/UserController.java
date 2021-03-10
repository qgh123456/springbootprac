package com.atqgh.springboot.controller;

import com.atqgh.springboot.configproperties.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: springbootprac
 * @Description:
 * @Author: qiguohui
 * @Date: 2021/2/19 20:51
 */

@RestController
@EnableConfigurationProperties
@RequestMapping("/user")
public class UserController {

    @Autowired
    private User user;

    @GetMapping("/get")
    public String get(){
        System.out.println("get request");
        return "get api";
    }

    @GetMapping("/test")
    public String test(){
        System.out.println("test request");
        return "test api";
    }


    @GetMapping("/user")
    public String user(){

        return user.getName1();
    }
}
