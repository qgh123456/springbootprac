package com.atqgh.springboot.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: springbootprac
 * @Description:
 * @Author: qiguohui
 * @Date: 2020/9/11 21:11
 */
//@Configuration
public class WebConfiguration {

    @Bean
    public FilterRegistrationBean registerFilter() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new Myfilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }


    @Bean
    public FilterRegistrationBean registerFilter2() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new Myfilter2());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter2");
        registration.setOrder(2);
        return registration;
    }
}
