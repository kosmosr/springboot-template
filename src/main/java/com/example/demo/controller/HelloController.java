package com.example.demo.controller;

import com.example.demo.common.ServerResponse;
import com.example.demo.validation.TestParameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

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

    @PostMapping("/post")
    public ServerResponse corsPostTest() {
        return ServerResponse.success();
    }

    @PutMapping("/put")
    public ServerResponse<Map> putTest() {
        Map<String, String> result = new HashMap<>(2);
        result.put("msg", "访问成功");
        result.put("code", "200");
        return ServerResponse.success(result);
    }
}
