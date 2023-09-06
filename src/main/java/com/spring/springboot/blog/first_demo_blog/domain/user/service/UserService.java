package com.spring.springboot.blog.first_demo_blog.domain.user.service;

import com.spring.springboot.blog.first_demo_blog.domain.user.dto.UserCreateRequest;
import com.spring.springboot.blog.first_demo_blog.domain.user.dto.UserCreateResponse;
import com.spring.springboot.blog.first_demo_blog.domain.user.dto.UserGetResponse;
import com.spring.springboot.blog.first_demo_blog.domain.user.dto.UserListResponse;

public interface UserService {
    UserListResponse list();

    UserCreateResponse saveUser(UserCreateRequest request);

    UserGetResponse getUser(String username);

    boolean existsByUsername(String username);

}
