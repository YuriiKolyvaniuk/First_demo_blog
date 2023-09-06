package com.spring.springboot.blog.first_demo_blog.domain.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogCreateRequest {

    //    @NotBlank(message = "Title is required field!")
    private String title;
    private String topic;
    //    @Size(min = 25, message = "Full text must be at least 25 characters!")
    private String fullText;


}
