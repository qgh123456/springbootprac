package com.atqgh.springboot;

import com.atqgh.springboot.configproperties.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan(value = "com.atqgh.springboot.mapper")
@ServletComponentScan(value = "com.atqgh.springboot.config")
@SpringBootApplication
@EnableConfigurationProperties(User.class)
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
