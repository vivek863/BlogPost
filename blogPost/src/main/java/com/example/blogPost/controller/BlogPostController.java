package com.example.blogPost.controller;

import com.example.blogPost.dto.BlogPostRequest;
import com.example.blogPost.model.BlogPost;
import com.example.blogPost.service.BlogPostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping
    public ResponseEntity<String> createPost(@Valid @RequestBody BlogPostRequest blogPostRequest) {
        blogPostService.createPost(blogPostRequest);
        return ResponseEntity.ok("You posted your blog!");
    }

    @GetMapping
    public List<BlogPost> getAllPosts() {
        return blogPostService.getAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getPostById(@PathVariable Long id) {
        return blogPostService.getPostById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePost(@PathVariable Long id, @RequestBody BlogPost updatedPost) {
        BlogPost updated = blogPostService.updatePost(id, updatedPost);
        if (updated != null) {
            return ResponseEntity.ok("Blog post updated successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        boolean deleted = blogPostService.deletePost(id);
        if (deleted) {
            return ResponseEntity.ok("Blog post deleted successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
