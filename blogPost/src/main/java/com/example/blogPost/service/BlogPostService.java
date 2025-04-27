package com.example.blogPost.service;

import com.example.blogPost.dto.BlogPostRequest;
import com.example.blogPost.model.BlogPost;
import com.example.blogPost.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;
    // Convert BlogPostRequest DTO to BlogPost Entity
    private BlogPost convertToEntity(BlogPostRequest request) {
        return BlogPost.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .author(request.getAuthor())
                .build();
    }
    public BlogPost createPost(BlogPostRequest postRequest) {
        BlogPost post = convertToEntity(postRequest);
        return blogPostRepository.save(post);
    }

    public List<BlogPost> getAllPosts() {
        return blogPostRepository.findAll();
    }

    public Optional<BlogPost> getPostById(Long id) {
        return blogPostRepository.findById(id);
    }

    public BlogPost updatePost(Long id, BlogPost updatedPost) {
        return blogPostRepository.findById(id)
                .map(post -> {
                    post.setTitle(updatedPost.getTitle());
                    post.setContent(updatedPost.getContent());
                    post.setAuthor(updatedPost.getAuthor());
                    return blogPostRepository.save(post);
                }).orElse(null);
    }

    public boolean deletePost(Long id) {
        if (blogPostRepository.existsById(id)) {
            blogPostRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
