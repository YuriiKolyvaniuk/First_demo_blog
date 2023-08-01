package com.spring.springboot.blog.First_demo_blog.repo;

import com.spring.springboot.blog.First_demo_blog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    public List<Post> findAllByTopic(String topic);
    public List<Post> findAllByTitleContainingIgnoreCaseOrTopicContainingIgnoreCase(String query, String query1);
}
