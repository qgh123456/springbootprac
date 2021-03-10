package com.atqgh.springboot.configproperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @ProjectName: springbootprac
 * @Description:
 * @Author: qiguohui
 * @Date: 2021/2/21 21:08
 */
@ConfigurationProperties(prefix = "user")
//@Component
@Data
public class User implements Serializable {
    private String name1;
    private String sex;
    private Integer age;
}
