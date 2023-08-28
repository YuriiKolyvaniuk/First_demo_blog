package com.spring.springboot.blog.First_demo_blog.domain.blog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogPostUpdateRequest {
    @NotBlank(message = "Title is required field!")
    private String title;
    private String topic;
    @Size(min = 25, message = "Full text must be at least 25 characters!")
    private String fullText;
}
