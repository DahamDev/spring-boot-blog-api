package com.spring.blog.springbootblogapi.repository;

import com.spring.blog.springbootblogapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository <Post, Integer> {
}
