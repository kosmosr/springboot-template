package com.example.demo.dto;

import com.example.demo.enums.HttpCodeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author kosmosr
 * @date 2018-10-25 19:51
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CodeErrorDTO<T> {
    private Integer errorCode;

    private String message;

    private T data;

    public CodeErrorDTO() {
    }

    public CodeErrorDTO(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public CodeErrorDTO(HttpCodeEnum codeEnum) {
        this.errorCode = codeEnum.getErrorCode();
        this.message = codeEnum.getMessage();
    }

    public CodeErrorDTO(HttpCodeEnum codeEnum, T data) {
        this.errorCode = codeEnum.getErrorCode();
        this.message = codeEnum.getMessage();
        this.data = data;
    }
}
