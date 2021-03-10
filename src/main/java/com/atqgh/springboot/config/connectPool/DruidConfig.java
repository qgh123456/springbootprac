//package com.atqgh.springboot.config.connectPool;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Controller;
//
//import javax.sql.DataSource;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Author: qiguohui
// * @Description:
// * @Date: Created in 21:56 2019/4/23
// * @Modified By:
// **/
//
//@Controller
//public class DruidConfig {
//
//    @ConfigurationProperties(prefix = "spring.datasource")
//    @Bean
//    public DataSource druid(){
//        return new DruidDataSource();
//    }
//
//    //配置Druid的监控
//    //配置一个管理后台的servlet
//    @Bean
//    public ServletRegistrationBean statViewServlet(){
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//        Map<String,String> initParams = new HashMap<String,String>();
//        initParams.put("loginUsername","admin"); // 登录的用户名
//        initParams.put("loginPassword","123456"); // 登录的密码
//        initParams.put("allow",""); // 允许哪些ip
//        initParams.put("deny",""); // 拒绝ip
//        servletRegistrationBean.setInitParameters(initParams);
//        return servletRegistrationBean;
//    }
//
//
//    //配置一个web监控的filter
//    @Bean
//    public FilterRegistrationBean webStatFilter(){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new WebStatFilter());
//        Map<String,String> initParams = new HashMap<>();
//        initParams.put("exclusions","*.js,*.css,/druid/*");
//        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
//        filterRegistrationBean.setInitParameters(initParams);
//        return filterRegistrationBean;
//    }
//}
