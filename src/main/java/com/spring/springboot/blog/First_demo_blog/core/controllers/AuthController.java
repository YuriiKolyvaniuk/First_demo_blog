package com.spring.springboot.blog.First_demo_blog.core.controllers;

import com.spring.springboot.blog.First_demo_blog.domain.user.persistence.User;
import com.spring.springboot.blog.First_demo_blog.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/signup")
    public String showRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String processRegistration(@ModelAttribute User user
            , Model model) {

        if (userService.existsByUsername(user.getUsername())){
            model.addAttribute("usernameError","This username is already used!");
            return "signup";
        }else {
            userService.saveUser(user);
            return "redirect:/login";
        }

    }

}
