package com.example.demo.controller;

import com.example.demo.common.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author kosmosr
 * @date 2018-10-25 18:19
 **/
@RestController
@RequestMapping({"${server.error.path:${error.path:/error}}"})
@Slf4j
public class CommonController implements ErrorController {

    private final static String PATH = "/error";

    @Autowired
    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(produces = {"text/html", "application/json"})
    public ServerResponse handleError(HttpServletRequest request) {
        WebRequest webRequest = new ServletWebRequest(request);
        Map<String, Object> errorAttributesData = errorAttributes.getErrorAttributes(webRequest, false);
        //状态码
        Integer status = (Integer) errorAttributesData.get("status");
        log.error("ERROR API Request: {}", errorAttributesData);

        return ServerResponse.error(HttpStatus.valueOf(status));
    }
}
