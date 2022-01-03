package com.spring.blog.springbootblogapi.controller;

import com.spring.blog.springbootblogapi.payload.CommentDto;
import com.spring.blog.springbootblogapi.repository.CommentRepository;
import com.spring.blog.springbootblogapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/{post_id}")
    public ResponseEntity<CommentDto> addComment(
            @RequestBody CommentDto commentDto, @PathVariable(name = "post_id") int postId){

        CommentDto response = commentService.addComment(commentDto, postId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{post_id}")
    public ResponseEntity<List<CommentDto>> getCommentByPost(@PathVariable(name = "post_id") int postId){

        return ResponseEntity.status(HttpStatus.OK).body(commentService.getCommentsByPost(postId));
    }

}
