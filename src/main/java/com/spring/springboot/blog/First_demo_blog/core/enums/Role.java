package com.spring.springboot.blog.First_demo_blog.core.enums;

import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER,ROLE_MODERATOR,ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
