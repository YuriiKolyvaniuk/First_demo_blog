package com.spring.springboot.blog.first_demo_blog.domain.blog;

import com.spring.springboot.blog.first_demo_blog.domain.blog.dto.*;
import com.spring.springboot.blog.first_demo_blog.domain.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/blog")
@Validated
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping()
    public BlogListResponse list() {
        return blogService.list();
    }

    @GetMapping("/topics/{topic}")
    public BlogListResponse getTopic(@PathVariable("topic") String topic) {
        return blogService.list(topic);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public BlogCreateResponse create(@RequestBody BlogCreateRequest request) {
        return blogService.create(request);
    }

    @GetMapping("/{id}")
    public BlogGetResponse get(@PathVariable(value = "id") long id) {
        return blogService.get(id);
    }

    @PutMapping("/{id}")
    public BlogUpdateResponse update(@PathVariable(value = "id") long id, @RequestBody BlogUpdateRequest blogUpdateRequest) {
        return blogService.update(id, blogUpdateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") long id) {
        blogService.delete(id);
    }

    @PutMapping("/{id}/undelete")
    public void undelete(@PathVariable(value = "id") long id) {
        blogService.undelete(id);
    }
}
