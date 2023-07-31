package com.spring.springboot.blog.First_demo_blog.repo;

import com.spring.springboot.blog.First_demo_blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);
    public boolean existsUserByUsername(String username);
}
