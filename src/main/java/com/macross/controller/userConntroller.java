package com.macross.controller;

import com.macross.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class userConntroller {
    @Autowired
    public userService userService;

    @RequestMapping("/test")
    @ResponseBody
    public void test(){
        String x;
        for (int i = 1; i<10;i++){
            x= userService.getcardname(i);
        }
    }
}