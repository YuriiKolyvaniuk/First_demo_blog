package com.spring.springboot.blog.first_demo_blog.domain.blog.mappers;

import com.spring.springboot.blog.first_demo_blog.domain.blog.dto.BlogCreateRequest;
import com.spring.springboot.blog.first_demo_blog.domain.blog.dto.BlogCreateResponse;
import com.spring.springboot.blog.first_demo_blog.domain.blog.dto.BlogGetResponse;
import com.spring.springboot.blog.first_demo_blog.domain.blog.dto.BlogListResponse;
import com.spring.springboot.blog.first_demo_blog.domain.blog.presistence.Blog;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface BlogMapper {
    Blog fromCreateRequest(BlogCreateRequest createRequest);
    BlogCreateResponse toCreateResponse(Blog blog);
    BlogGetResponse toGetResponse(Blog blog);
    BlogListResponse.Blog toListResponse(Blog blog);
}
