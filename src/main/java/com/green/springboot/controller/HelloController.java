package com.green.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String SayHello(){
        return "hello  小伙伴，现在是：" +String.format(new Date().toString(), "YYYY/MM/DD");

    }

    @RequestMapping("/success")
    public String  success(Map<String,Object> map){
        map.put("say","how are you？");
        map.put("hello","<h2>whats your name? </h2");
        map.put("id", UUID.randomUUID());
        map.put("class","guanghuisuiyue");
        map.put("users", Arrays.asList("张三","李四","王考虑进来"));
        return "success";
    }
}
