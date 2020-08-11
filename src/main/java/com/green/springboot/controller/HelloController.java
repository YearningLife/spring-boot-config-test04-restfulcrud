package com.green.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String SayHello(){
        return "hello  小伙伴，现在是：" +String.format(new Date().toString(), "YYYY/MM/DD");

    }

    @RequestMapping("/succ")
    public Object  getSuccess(){
        return "success";
    }
}
