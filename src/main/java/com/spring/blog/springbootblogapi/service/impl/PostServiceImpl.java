package com.spring.blog.springbootblogapi.service.impl;

import com.spring.blog.springbootblogapi.entity.Post;
import com.spring.blog.springbootblogapi.exception.ResourceNotFoundException;
import com.spring.blog.springbootblogapi.payload.PostDto;
import com.spring.blog.springbootblogapi.repository.CommentRepository;
import com.spring.blog.springbootblogapi.repository.PostRepository;
import com.spring.blog.springbootblogapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Override
    public PostDto addPost(PostDto postDto) {
        Post post = maptoPost(postDto);
        Post newPost = postRepository.save(post);
        PostDto response = maptoDto(newPost);
        return response;


    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> allPosts = postRepository.findAll();
        List<PostDto> response =allPosts.stream().map(post->maptoDto(post)).collect(Collectors.toList());
        return response;
    }

    @Override
    public PostDto getPostById(int id) {
        Post post = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("get post by id","no post for the id"));
        PostDto response = maptoDto(post);
        return response;
    }

    @Override
    public PostDto updatePost(PostDto postDto, int id) {
        Post updatedPost = postRepository.getById(id);
        updatedPost.setTitle(postDto.getTitle());
        updatedPost.setDescription(postDto.getDescription());
        updatedPost.setContent(postDto.getContent());
        return maptoDto(postRepository.save(updatedPost));
    }

    @Override
    public List<PostDto> getPostsPerPage(int pageNumber, int numberOfItems) {
        Pageable pagebale = PageRequest.of(pageNumber,numberOfItems, Sort.by("title"));
        Page<Post> allPosts = postRepository.findAll(pagebale);
        return allPosts.stream().map(post -> maptoDto(post)).collect(Collectors.toList());
    }


    private PostDto maptoDto( Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setContent(post.getContent());
        postDto.setDescription(post.getDescription());
        postDto.setTitle(post.getTitle());

        return postDto;
    }


    private Post maptoPost(PostDto postDto){
        Post post = new Post();
        post.setId(postDto.getId());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());
        return post;
    }

}
