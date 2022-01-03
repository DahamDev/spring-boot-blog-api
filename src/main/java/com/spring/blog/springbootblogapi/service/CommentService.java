package com.spring.blog.springbootblogapi.service;

import com.spring.blog.springbootblogapi.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto addComment(CommentDto comment , int postId);
    List<CommentDto> getCommentsByPost(int postId);
}
