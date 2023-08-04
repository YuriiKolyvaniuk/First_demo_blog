package com.spring.springboot.blog.First_demo_blog.services.post;

import com.spring.springboot.blog.First_demo_blog.models.Post;

import java.util.List;

public interface PostService {
    public List<Post> getAllPosts();
    public void savePost(Post post);
    public Post getPost(Long id);
    public void deletePost(Long id);
    public void deletePost(Post post);
    public List<Post> getByTopic(String topic);
    public List<Post> searchPosts(String query);
    public void updatePost(Long id, String title, String topic, String fullText);
}
