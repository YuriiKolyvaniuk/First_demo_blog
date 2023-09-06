package com.spring.springboot.blog.first_demo_blog.domain.blog.service;

import com.spring.springboot.blog.first_demo_blog.domain.blog.dto.*;

public interface BlogService {
    BlogListResponse list();

    BlogListResponse list(String topic);

    BlogCreateResponse create(BlogCreateRequest request);

    BlogGetResponse get(Long id);

    BlogUpdateResponse update(Long id, BlogUpdateRequest blogUpdateRequest);

    void delete(Long id);

    void undelete(Long id);
}
