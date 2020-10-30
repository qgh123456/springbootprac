package com.atqgh.springboot.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: qiguohui
 * @Description:
 * @Date: Created in 23:34 2019/4/24
 * @Modified By:
 **/
@Data
public class Employee implements Serializable {

    private Integer id;
    private String lastName;
    private Integer gender;
    private String email;
    private Integer dId;

}
