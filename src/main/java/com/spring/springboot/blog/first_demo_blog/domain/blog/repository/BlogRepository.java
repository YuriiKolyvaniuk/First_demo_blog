package com.spring.springboot.blog.first_demo_blog.domain.blog.repository;

import com.spring.springboot.blog.first_demo_blog.domain.blog.presistence.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findAllByTopic(String topic);

    @Query("SELECT p FROM Blog p WHERE p.title LIKE %?1% OR p.topic LIKE %?2%")
    List<Blog> searchPosts(String query, String query1);

    Optional<Blog> findByIdAndDeleted(Long id, boolean deleted);
}
