package com.spring.springboot.blog.first_demo_blog.domain.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogGetResponse {
    private Long id;
    private String title;
    private String topic;
    private String fullText;
    private int goodGrade;
    private int badGrade;
    private boolean deleted;
}
