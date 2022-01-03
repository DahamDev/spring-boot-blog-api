package com.spring.blog.springbootblogapi.repository;

import com.spring.blog.springbootblogapi.entity.Comment;
import com.spring.blog.springbootblogapi.payload.CommentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query(value = "SELECT * from comments c where c.id =?1 ", nativeQuery = true)
    List<Comment> getCommentsByPost(int postId);
}
