package com.green.springboot.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/*
EnableWebMvc如果开启后，会全面接管spring mvc，所有配置需要自己配
原因：
  1.  @EnableWebMvc   进入后发现会调用 @Import(DelegatingWebMvcConfiguration.class)，
  2.  spring boot 自动生效的前置条件为 WebMvcAutoConfiguration类中的 前提条件就是不能包含上述类：DelegatingWebMvcConfiguration
        代码中体现：@ConditionalOnMissingBean(WebMvcConfigurationSupport.class)
 */
//@EnableWebMvc
@Controller
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    /*
    1. 引入自己配置的拦截器
    2.访问指定地址时，可进行跳转
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        registry.addViewController("/one").setViewName("/success");

    }


}
