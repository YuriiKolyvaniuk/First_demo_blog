package com.spring.springboot.blog.first_demo_blog.domain.user.service;


import com.spring.springboot.blog.first_demo_blog.core.enums.Role;
import com.spring.springboot.blog.first_demo_blog.domain.user.dto.UserCreateRequest;
import com.spring.springboot.blog.first_demo_blog.domain.user.dto.UserCreateResponse;
import com.spring.springboot.blog.first_demo_blog.domain.user.dto.UserGetResponse;
import com.spring.springboot.blog.first_demo_blog.domain.user.dto.UserListResponse;
import com.spring.springboot.blog.first_demo_blog.domain.user.persistence.User;
import com.spring.springboot.blog.first_demo_blog.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserListResponse list() {
        List<UserListResponse.User> users = userRepository.findAll().stream().map(user -> UserListResponse.User.builder()
                .id(user.getId())
                .username(user.getUsername())
                .roles(user.getRoles().stream().map(String::valueOf).toList())
                .build()).toList();
        return UserListResponse.builder().data(users).build();
    }

    @Override
    public UserCreateResponse saveUser(UserCreateRequest request) {
        User user = new User();
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setUsername(request.getUsername());
        user.setEnabled(true);
        user.getRoles().addAll(request.getRoles().stream().map(Role::valueOf).toList());

        user = userRepository.save(user);

        return UserCreateResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .roles(user.getRoles().stream().map(String::valueOf).toList())
                .build();
    }

    @Override
    public UserGetResponse getUser(String username) {
        User user = userRepository.findByUsername(username);

        return UserGetResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .roles(user.getRoles().stream().map(String::valueOf).toList())
                .build();
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsUserByUsername(username);
    }

}
