package com.example.demo.enums;

import lombok.Getter;

/**
 * @author kosmosr
 * @date 2018-10-25 19:53
 **/
@Getter
public enum HttpCodeEnum {
    /**
     * 错误状态码枚举
     */
    PARAMETER_ERROR(40401, "参数错误");
    private Integer errorCode;

    private String message;

    HttpCodeEnum(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
