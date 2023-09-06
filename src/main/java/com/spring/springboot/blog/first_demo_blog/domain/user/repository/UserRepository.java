package com.spring.springboot.blog.first_demo_blog.domain.user.repository;

import com.spring.springboot.blog.first_demo_blog.domain.user.persistence.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    boolean existsUserByUsername(String username);
}
