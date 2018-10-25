package com.example.demo.controller;

import com.example.demo.common.ServerResponse;
import com.example.demo.validation.TestParameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author kosmosr
 * @date 2018-10-25 17:14
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public ServerResponse hello(@Valid TestParameter parameter) {
        return ServerResponse.success("hello" + parameter.getName());
    }
}
