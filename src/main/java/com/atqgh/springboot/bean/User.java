package com.atqgh.springboot.bean;

import lombok.Data;

/**
 * @Author: qiguohui
 * @Description:
 * @Date: Created in 9:32 2019/7/3
 * @Modified By:
 **/
@Data
public class User {

    private Integer id;
    private String account;
    private String username;
    private Integer regTime;

}
