package com.spring.springboot.blog.First_demo_blog.domain.blog.service;

import com.spring.springboot.blog.First_demo_blog.domain.blog.dto.BlogListResponse;
import com.spring.springboot.blog.First_demo_blog.domain.blog.dto.BlogPostUpdateRequest;
import com.spring.springboot.blog.First_demo_blog.domain.blog.presistence.Post;
import com.spring.springboot.blog.First_demo_blog.domain.blog.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{


    private final PostRepository postRepository;

    @Override
    public BlogListResponse getAllPosts() {
        List<Post> allPosts = postRepository.findAll();
        List<BlogListResponse.Blog> blocks = allPosts.stream().map(post -> {
            BlogListResponse.Blog blog = new BlogListResponse.Blog();
            blog.setId(post.getId());
            blog.setTitle(post.getTitle());
            blog.setTopic(post.getTopic());
            blog.setFullText(post.getFullText());
            blog.setGoodGrade(post.getGoodGrade());
            blog.setBadGrade(post.getBadGrade());

            return blog;
        }).toList();
        return BlogListResponse.builder().data(blocks).build();
    }

    @Override
    public void savePost(Post post) {
        postRepository.save(post);
    }

    @Override
    public Post getPost(Long id) {
        Post post = null;

        Optional<Post> optional = postRepository.findById(id);

        if(optional.isPresent()){
            post = optional.get();
        }

        return post;
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> getByTopic(String topic) {
        return postRepository.findAllByTopic(topic);
    }


    @Override
    public void updatePost(Long id, BlogPostUpdateRequest blogPostUpdateRequest) {

        Post post = getPost(id);

        post.setTitle(blogPostUpdateRequest.getTitle());
        post.setTopic(blogPostUpdateRequest.getTopic());
        post.setFullText(blogPostUpdateRequest.getFullText());

        postRepository.save(post);

    }

    @Override
    public List<Post> getAllPosts(String query) {
        return postRepository.searchPosts(query, query);
    }
}
