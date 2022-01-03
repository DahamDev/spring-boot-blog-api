package com.spring.blog.springbootblogapi.service.impl;

import com.spring.blog.springbootblogapi.entity.Comment;
import com.spring.blog.springbootblogapi.entity.Post;
import com.spring.blog.springbootblogapi.payload.CommentDto;
import com.spring.blog.springbootblogapi.repository.CommentRepository;
import com.spring.blog.springbootblogapi.repository.PostRepository;
import com.spring.blog.springbootblogapi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Override
    public CommentDto addComment(CommentDto comment, int postId) {

        Comment newComment = dtoToEntity(comment, postId);
        commentRepository.save(newComment);
        return entityToDto(newComment);
    }

    @Override
    public List<CommentDto> getCommentsByPost(int postId) {
        List<Comment> response = commentRepository.getCommentsByPost(postId);
        List <CommentDto> res= response.stream().map(comment -> entityToDto(comment)).collect(Collectors.toList());
        return res;
    }


    private Comment dtoToEntity( CommentDto commentDto, int postId){

        Comment comment = new Comment();
        comment.setBody(commentDto.getBody());
        comment.setDate(new Date());
        Post post = postRepository.getById(postId);
        comment.setPost(post);

        System.out.println(comment.getDate());
        return comment;
    }

    private CommentDto entityToDto (Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setBody(comment.getBody());
        return commentDto;
    }
}
