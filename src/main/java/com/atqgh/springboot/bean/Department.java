package com.atqgh.springboot.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: qiguohui
 * @Description:
 * @Date: Created in 23:36 2019/4/24
 * @Modified By:
 **/
@Data
public class Department implements Serializable {

    private Integer id;
    private String departmentName;
}
