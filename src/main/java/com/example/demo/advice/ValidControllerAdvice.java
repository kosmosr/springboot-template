package com.example.demo.advice;

import com.example.demo.common.ServerResponse;
import com.example.demo.dto.CodeErrorDTO;
import com.example.demo.enums.HttpCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kosmosr
 * @date 2018-10-25 19:41
 **/
@RestControllerAdvice
@Slf4j
public class ValidControllerAdvice {

    @ExceptionHandler(BindException.class)
    public ServerResponse handler(BindException e) {
        List<String> collect = null;
        if (e.hasErrors()) {
            collect = e.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            log.error("参数错误: {}", collect);
        }
        return ServerResponse.errorHttp(new CodeErrorDTO<>(HttpCodeEnum.PARAMETER_ERROR, collect));
    }
}
