package com.spring.springboot.blog.First_demo_blog.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    @NotBlank(message = "Title is required field!")
    private String title;

    @Column(name = "topic")
    private String topic;

    @Column(name = "full-text")
    @Size(min = 25, message = "Full text must be at least 25 characters!")
    private String full_text;

    @Column(name = "good-grade")
    private int goodGrade;

    @Column(name = "bad-grade")
    private int badGrade;

    public Post() {
    }

    public Post(String title, String topic, String full_text) {
        this.title = title;
        this.topic = topic;
        this.full_text = full_text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public int getGoodGrade() {
        return goodGrade;
    }

    public void setGoodGrade(int goodGrade) {
        this.goodGrade = goodGrade;
    }

    public int getBadGrade() {
        return badGrade;
    }

    public void setBadGrade(int badGrade) {
        this.badGrade = badGrade;
    }
}
