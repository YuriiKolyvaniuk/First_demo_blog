package com.spring.springboot.blog.first_demo_blog.domain.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogListResponse {

    private List<Blog> data;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Blog{
        private Long id;
        private String title;
        private String topic;
        private String fullText;
        private int goodGrade;
        private int badGrade;
        private boolean deleted;
    }


}
