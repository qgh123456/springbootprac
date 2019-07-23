package com.atqgh.springboot.common.entity;

import com.atqgh.springboot.common.enums.ExceptionEnum;
import lombok.Data;

/**
 * @author bystander
 * @date 2018/9/15
 *
 * 自定义异常结果类
 */
@Data
public class ExceptionResult {

    private int status;

    private String message;

    private long timestamp;

    public ExceptionResult(ExceptionEnum em) {
        this.status = em.getCode();
        this.message = em.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}
