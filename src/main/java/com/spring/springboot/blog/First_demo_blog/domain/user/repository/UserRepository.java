package com.spring.springboot.blog.First_demo_blog.domain.user.repository;

import com.spring.springboot.blog.First_demo_blog.domain.user.persistence.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);
    public boolean existsUserByUsername(String username);
}
