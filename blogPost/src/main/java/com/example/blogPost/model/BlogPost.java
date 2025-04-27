package com.example.blogPost.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @NotBlank(message = "Author is required")
    private String author;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }


    // Constructors
//    public BlogPost() {
//        this.createdAt = LocalDateTime.now();
//    }
//
//    public BlogPost(String title, String content, String author) {
//        this.title = title;
//        this.content = content;
//        this.author = author;
//        this.createdAt = LocalDateTime.now();
//    }

    // Getters and Setters

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) { this.id = id; }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) { this.title = title; }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) { this.content = content; }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) { this.author = author; }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
