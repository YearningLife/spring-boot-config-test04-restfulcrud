package com.green.springboot.component;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        String lang = request.getParameter("lang");
        Locale locale = request.getLocale();//获取请求头中的信息
        if (!StringUtils.isEmpty(lang)) {
            String[] strings = lang.split("_");
            locale = new Locale(strings[0], strings[1]);
        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
