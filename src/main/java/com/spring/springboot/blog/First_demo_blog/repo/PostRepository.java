package com.spring.springboot.blog.First_demo_blog.repo;

import com.spring.springboot.blog.First_demo_blog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    public List<Post> findAllByTopic(String topic);
    @Query("SELECT p FROM Post p WHERE p.title LIKE %?1% OR p.topic LIKE %?2%")
    public List<Post> searchPosts(String query, String query1);
}
