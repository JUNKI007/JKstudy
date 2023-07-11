package com.example.demo.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionController {
    @ExceptionHandler(MemberNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(MemberNotFound e, HttpServletRequest request){
        e.printStackTrace();
        System.out.println(
                request.getRequestURI() + "를 하는데" + e.getMemberId() +"이 놈이 없어서 사고가 났어요" );
        return e.getMessage();
    }
}