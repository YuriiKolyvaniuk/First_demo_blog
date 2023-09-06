package com.spring.springboot.blog.first_demo_blog.domain.blog.service;

import com.spring.springboot.blog.first_demo_blog.domain.blog.dto.*;
import com.spring.springboot.blog.first_demo_blog.domain.blog.exception.BlogNotFoundException;
import com.spring.springboot.blog.first_demo_blog.domain.blog.mappers.BlogMapper;
import com.spring.springboot.blog.first_demo_blog.domain.blog.presistence.Blog;
import com.spring.springboot.blog.first_demo_blog.domain.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {
    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;

    @Override
    public BlogListResponse list() {
        List<BlogListResponse.Blog> blocks = blogRepository.findAll().stream().map(blogMapper::toListResponse).toList();

        return BlogListResponse.builder().data(blocks).build();
    }

    @Override
    public BlogListResponse list(String topic) {
        List<BlogListResponse.Blog> blogs = blogRepository.findAllByTopic(topic).stream().map(blogMapper::toListResponse).toList();

        return BlogListResponse.builder().data(blogs).build();
    }

    @Override
    public BlogCreateResponse create(BlogCreateRequest request) {
        Blog blog = blogMapper.fromCreateRequest(request);

        blogRepository.save(blog);

        return blogMapper.toCreateResponse(blog);
    }

    public BlogGetResponse get(Long id) {
        Blog blog = getRaw(id, false);

        return blogMapper.toGetResponse(blog);
    }

    @Override
    public BlogUpdateResponse update(Long id, BlogUpdateRequest blogUpdateRequest) {

        Blog blog = getRaw(id, false);


        blog.setTitle(blogUpdateRequest.getTitle());
        blog.setTopic(blogUpdateRequest.getTopic());
        blog.setFullText(blogUpdateRequest.getFullText());

        blogRepository.save(blog);

        return BlogUpdateResponse.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .topic(blog.getTopic())
                .fullText(blog.getFullText())
                .goodGrade(blog.getGoodGrade())
                .badGrade(blog.getBadGrade())
                .deleted(blog.isDeleted())
                .build();
    }

    @Override
    public void delete(Long id) {
        Blog blog = getRaw(id, false);
        blog.setDeleted(true);
        blogRepository.save(blog);
    }

    @Override
    public void undelete(Long id) {
        Blog blog = getRaw(id, true);
        blog.setDeleted(false);
        blogRepository.save(blog);
    }

    private Blog getRaw(Long id, boolean deleted){
        return blogRepository.findByIdAndDeleted(id, deleted).orElseThrow(BlogNotFoundException::new);
    }

}
