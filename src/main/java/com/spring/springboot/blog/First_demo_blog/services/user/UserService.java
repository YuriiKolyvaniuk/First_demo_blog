package com.spring.springboot.blog.First_demo_blog.services.user;

import com.spring.springboot.blog.First_demo_blog.models.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public void saveUser(User user);
    public User getUser(String username);
    public boolean existsByUsername(String username);

}
