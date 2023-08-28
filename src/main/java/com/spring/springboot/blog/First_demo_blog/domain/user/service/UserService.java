package com.spring.springboot.blog.First_demo_blog.domain.user.service;

import com.spring.springboot.blog.First_demo_blog.domain.user.persistence.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public void saveUser(User user);
    public User getUser(String username);
    public boolean existsByUsername(String username);

}
