package com.example.demo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author kosmosr
 * @date 2018-10-25 17:17
 **/
@Aspect
@Component
@Slf4j
public class WebLogAspect {

    @Pointcut("execution(public * com.example.demo.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        log.info("HTTP_METHOD: {}, URL : {}, IP: {}", request.getMethod(),
                request.getRequestURL().toString(), request.getRemoteAddr());
        log.info("CLASS_METHOD : {}, ARGS: {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));

    }
}
