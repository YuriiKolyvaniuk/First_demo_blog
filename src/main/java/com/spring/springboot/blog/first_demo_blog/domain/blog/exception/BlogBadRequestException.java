package com.spring.springboot.blog.first_demo_blog.domain.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Bad request")
public class BlogBadRequestException extends RuntimeException {

}
