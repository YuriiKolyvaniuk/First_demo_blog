package com.spring.springboot.blog.First_demo_blog.controllers;

import com.spring.springboot.blog.First_demo_blog.dto.BlogPostUpdateRequest;
import com.spring.springboot.blog.First_demo_blog.models.Post;
import com.spring.springboot.blog.First_demo_blog.services.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/blog")
@Validated
@RequiredArgsConstructor
public class BlogController {

    private static final List<String> TOPICS = Arrays.asList("World", "Technology", "Design", "Culture", "Business", "Politics", "Opinion", "Science", "Health", "Style", "Travel", "Other");


    private final PostService postService;

    @GetMapping
    public String blogMain(Model model) {

        List<Post> posts = postService.getAllPosts();

        model.addAttribute("posts", posts);

        return "blog-main";
    }

    @GetMapping("/add")
    public String blogAdd(Model model) {
        model.addAttribute("topics", TOPICS);
        model.addAttribute("post", new Post());
        return "blog-add";
    }

    @PostMapping("/add")
    public String blogPostAdd(@Validated @ModelAttribute Post post, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("topics", TOPICS);
            return "blog-add";
        }

        postService.savePost(post);

        return "redirect:/blog";
    }

    @GetMapping("/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        Post post = postService.getPost(id);

        model.addAttribute("post", post);


        return "blog-details";
    }

    @GetMapping("/edit/{id}")
    public String blogEdit(@PathVariable(value = "id") long id, Model model) {
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        model.addAttribute("topics", TOPICS);

        return "blog-edit";
    }

    @PostMapping("/edit/{id}")
    public String blogPostUpdate(@PathVariable(value = "id") long id,@Validated @ModelAttribute BlogPostUpdateRequest blogPostUpdateRequest) {


        postService.updatePost(id, blogPostUpdateRequest);

        return "redirect:/blog";
    }

    @PostMapping("/remove/{id}")
    public String blogRemove(@PathVariable(value = "id") long id) {
        postService.deletePost(id);

        return "redirect:/blog";
    }

    @GetMapping("/topics/{topic}")
    public String getTopic(@PathVariable("topic") String topic, Model model) {
        if (TOPICS.stream().anyMatch(t -> t.equalsIgnoreCase(topic))) {
            List<Post> posts = postService.getByTopic(topic);
            model.addAttribute("topic", topic);
            model.addAttribute("posts", posts);

            return "blog-topic";

        } else {
            return "topic-not-found";
        }
    }


    @GetMapping("/search")
    public String search(@RequestParam("query") String query, Model model) {
        List<Post> searchResults = postService.searchPosts(query);
        if (searchResults.isEmpty()) {
            return "not-found";
        }
        model.addAttribute("results", searchResults);

        return "search-results";
    }



}
