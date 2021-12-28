package com.spring.blog.springbootblogapi.repository;

import com.spring.blog.springbootblogapi.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
