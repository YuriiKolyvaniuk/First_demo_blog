package com.spring.springboot.blog.first_demo_blog.domain.user;


import com.spring.springboot.blog.first_demo_blog.domain.user.dto.UserCreateRequest;
import com.spring.springboot.blog.first_demo_blog.domain.user.dto.UserCreateResponse;
import com.spring.springboot.blog.first_demo_blog.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserCreateResponse create(@RequestBody UserCreateRequest request) {
        return userService.saveUser(request);
    }
}
