package com.example.demo2.repository;

import com.example.demo2.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IRepositoryPost {
    Page<Post> findAll(Pageable pageable);
}
