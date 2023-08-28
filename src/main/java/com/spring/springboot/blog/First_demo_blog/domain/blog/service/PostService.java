package com.spring.springboot.blog.First_demo_blog.domain.blog.service;

import com.spring.springboot.blog.First_demo_blog.domain.blog.dto.BlogListResponse;
import com.spring.springboot.blog.First_demo_blog.domain.blog.dto.BlogPostUpdateRequest;
import com.spring.springboot.blog.First_demo_blog.domain.blog.presistence.Post;

import java.util.List;

public interface PostService {
    BlogListResponse getAllPosts();
    List<Post> getAllPosts(String query);
    void savePost(Post post);
    Post getPost(Long id);
    void updatePost(Long id, BlogPostUpdateRequest blogPostUpdateRequest);
    void deletePost(Long id);
    List<Post> getByTopic(String topic);


}
