package com.spring.springboot.blog.first_demo_blog.domain.blog.presistence;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "blog")
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class Blog {
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ToString.Include
    @Column(name = "title")
    private String title;

    @ToString.Include
    @Column(name = "topic")
    private String topic;

    @ToString.Include
    @Column(name = "full-text")
    private String fullText;

    @ToString.Include
    @Column(name = "good-grade")
    private int goodGrade;

    @ToString.Include
    @Column(name = "bad-grade")
    private int badGrade;

    @Column(name = "deleted")
    private boolean deleted;
}
