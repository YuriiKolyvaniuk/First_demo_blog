package com.spring.springboot.blog.First_demo_blog.services.post;

import com.spring.springboot.blog.First_demo_blog.models.Post;
import com.spring.springboot.blog.First_demo_blog.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

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
    public List<Post> searchPosts(String query) {
        return postRepository.findAllByTitleContainingIgnoreCaseOrTopicContainingIgnoreCase(query, query);
    }
}
