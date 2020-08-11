package com.green.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class SpringBootConfigTest04RestfulcrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConfigTest04RestfulcrudApplication.class, args);
    }

    @Bean
    public ViewResolver myViewResolver(){

        MyViewResolver myViewResolver1 = new MyViewResolver();

        return myViewResolver1;
    }

    public class MyViewResolver implements ViewResolver{

        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }
}
