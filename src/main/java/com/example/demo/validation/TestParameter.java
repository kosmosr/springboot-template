package com.example.demo.validation;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author kosmosr
 * @date 2018-10-25 19:24
 **/
@Data
public class TestParameter {
    @NotEmpty(message = "姓名不能为空")
    private String name;

    @NotNull(message = "年龄不能为空")
    private Integer age;
}
