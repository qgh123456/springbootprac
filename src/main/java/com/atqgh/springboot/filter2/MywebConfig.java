package com.atqgh.springboot.filter2;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ProjectName: springbootprac
 * @Description:
 * @Author: qiguohui
 * @Date: 2021/2/19 20:52
 */

@Configuration
public class MywebConfig implements WebMvcConfigurer {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public FilterRegistrationBean AFilterRegist() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new AFilter());
        frBean.addUrlPatterns("/user/test");
        System.out.println("注册 A");
        frBean.setOrder(1);
        return frBean;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public FilterRegistrationBean BFilterRegist() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new BFilter());
        frBean.addUrlPatterns("/user/test");
        System.out.println("注册 B");
        frBean.setOrder(2);
        return frBean;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public FilterRegistrationBean CFilterRegist() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new CFilter());
        frBean.addUrlPatterns("/user/get");
        System.out.println("注册 C");
        frBean.setOrder(3);
        return frBean;
    }
}
