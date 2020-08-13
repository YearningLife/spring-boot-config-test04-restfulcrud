package com.green.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Controller
public class HelloController {

    /*
    1.页面访问/hello，使用本方法
    2.返回时需要@ResponseBody ，@Controller 配置，可在类上面@RestController替换前面两个
     */
    @ResponseBody
    @RequestMapping("/hello")
    public String SayHello(){
        return "hello  小伙伴，现在是：" +String.format(new Date().toString(), "YYYY/MM/DD");

    }

    /*
    1.启动后，访问success，会调用该方法，并且返回字段内容
    2.可以使用视图解析器，参考spring mvc中内容
    3.return "success"; 这个success 返回时访问的时success.html内容，界面使用thymeleaf，需要先引入依赖，参考pom文件
    4.调用时不能使用@ResponseBody
     */
    @RequestMapping("/success")
    public String  success(Map<String,Object> map){
        map.put("say","how are you？");
        map.put("hello","<h2>whats your name? </h2");
        map.put("id", UUID.randomUUID());
        map.put("class","guanghuisuiyue");
        map.put("users", Arrays.asList("张三","李四","王考虑进来"));
        return "success";
    }
    /*
    1. 当访问 “/”，“/index.html”时都会跳转到login.html
    2. 不需要@ResponseBody
     */
/*    @RequestMapping({"/","/index.html"})
    public String index(){

        return "login";
    }*/
}
