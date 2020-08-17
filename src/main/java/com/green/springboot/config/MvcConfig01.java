package com.green.springboot.config;

import com.green.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
    1.此处实现WebMvcConfigurerAdapter的父类 WebMvcConfigurer
 */
@Controller
public class MvcConfig01 implements WebMvcConfigurer {

    /*
    1.添加视图解析器，当访问“/”，“/index” 时均可跳转到登陆页面
    2.使用时要使用@Bean配置
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){

        WebMvcConfigurer mvcConfigurer = new WebMvcConfigurer() {

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
            }

        };
        return mvcConfigurer;
    }
  @Bean
    public LocaleResolver localeResolver(){


        return new MyLocaleResolver();
    }

}
