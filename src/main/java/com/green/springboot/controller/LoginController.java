package com.green.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;
//柜面登陆处理过程 ，包含springmvc内容
//1.@PostMapping 相当于  @RequestMapping(method = RequestMethod.POST)    包含两个意思：请求方式post、requestmapping映射
//2. RequestParam 作为必输参数
@Controller
public class LoginController {

    /*
    1. 判断用户名、密码是否存在
    2. 将username密码放在session中，其他地方可做调用
    3. 重定向至新的页面，可防止页面中有重复提交提示
     */
    @PostMapping(value = "/user/login")
    public String userLogin(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,String> map, HttpSession httpSession){
        //登陆成功
        if (!StringUtils.isEmpty(username) && "123456".equals(password) && username.startsWith("adm")) {
            httpSession.setAttribute("userName",username);
            return "redirect:/main.html";
        }else { //登陆失败
            map.put("msg","用户名或密码错误，请重新输入");
            return "login";
        }

    }
}
