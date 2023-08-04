package com.spring.springboot.blog.First_demo_blog.services.post;

import com.spring.springboot.blog.First_demo_blog.dto.BlogPostUpdateRequest;
import com.spring.springboot.blog.First_demo_blog.models.Post;
import com.spring.springboot.blog.First_demo_blog.repo.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{


    private final PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
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
    public void deletePost(Post post) {
        postRepository.delete(post);
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
    public List<Post> searchPosts(String query) {
        return postRepository.searchPosts(query, query);
    }
}
