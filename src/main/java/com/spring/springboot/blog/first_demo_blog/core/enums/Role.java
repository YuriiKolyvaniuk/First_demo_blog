package com.spring.springboot.blog.first_demo_blog.core.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER, ROLE_MODERATOR, ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
