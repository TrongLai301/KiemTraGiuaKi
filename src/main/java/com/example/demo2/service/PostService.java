package com.example.demo2.service;

import com.example.demo2.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    Page<Post> getAllPosts(Pageable pageable);
}