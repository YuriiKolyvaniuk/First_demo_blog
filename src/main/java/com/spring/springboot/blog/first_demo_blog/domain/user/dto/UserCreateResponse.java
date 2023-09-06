package com.spring.springboot.blog.first_demo_blog.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateResponse {
    private Long id;
    private String username;
    private List<String> roles;
}
