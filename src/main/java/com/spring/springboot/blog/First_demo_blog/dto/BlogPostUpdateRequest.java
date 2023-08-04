package com.spring.springboot.blog.First_demo_blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogPostUpdateRequest {
    private String title;
    private String topic;
    private String fullText;
}
