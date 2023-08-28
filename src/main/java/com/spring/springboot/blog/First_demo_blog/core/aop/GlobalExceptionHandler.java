package com.spring.springboot.blog.First_demo_blog.core.aop;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public String handleException(Exception ex, Model model) {
        model.addAttribute("errorMessage", "The requested page does not exist. Please check your link.");

        return "error";
    }
}

