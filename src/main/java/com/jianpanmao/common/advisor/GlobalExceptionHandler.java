package com.jianpanmao.common.advisor;

import com.jianpanmao.common.entity.ResultEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResultEntity notFoundPage404(HttpServletResponse response) {
        response.setStatus(200);
        return new ResultEntity(404,"没有找到资源","没有找到资源");
    }


    @ExceptionHandler(ArithmeticException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultEntity  byZero(HttpServletResponse response) {
        response.setStatus(200);
        return new ResultEntity(10000,"0不能被除","0不能被除");
    }
}
