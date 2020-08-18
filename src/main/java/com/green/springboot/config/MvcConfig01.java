package com.green.springboot.config;

import com.green.springboot.component.LoginHandlerInterceptor;
import com.green.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
                registry.addViewController("/main.html").setViewName("dashboard");
            }

        };

        return mvcConfigurer;
    }
    //国际化
  @Bean
    public LocaleResolver localeResolver(){


        return new MyLocaleResolver();
    }

     /*
    1. LoginHandlerInterceptor 为新增的拦截器
    2.这个方法用来新增登陆的拦截器
    3. 应当将登陆地址、首页地址排除掉
    4. 本地的静态资源无法加载，需要排除在路径之外


    未解决问题，页面点击侧边栏请求会遭到拦截
     */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/login.html","/index.html","/user/login","/asserts/**","/webjars/**");
    }
}
