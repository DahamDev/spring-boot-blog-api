package com.spring.blog.springbootblogapi.service;

import com.spring.blog.springbootblogapi.entity.Post;
import com.spring.blog.springbootblogapi.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto addPost(PostDto postDto);
    List<PostDto> getAllPosts();
    PostDto getPostById(int id);
    PostDto updatePost( PostDto postDto,int id);
    List<PostDto> getPostsPerPage(int pageNumber, int numberOfItems);
 }
