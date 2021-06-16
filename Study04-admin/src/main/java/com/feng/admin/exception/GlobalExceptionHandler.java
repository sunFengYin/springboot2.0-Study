package com.feng.admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 处理整个web controller的异常
 *
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    //异常处理器
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})
    public String handlerArithExceprion(Exception e){
        log.error("异常信息为:{}",e);
        return "login";
    }
}
