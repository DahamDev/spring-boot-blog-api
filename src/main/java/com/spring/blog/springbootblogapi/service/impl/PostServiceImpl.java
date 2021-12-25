package com.spring.blog.springbootblogapi.service.impl;

import com.spring.blog.springbootblogapi.entity.Post;
import com.spring.blog.springbootblogapi.payload.PostDto;
import com.spring.blog.springbootblogapi.repository.PostRepository;
import com.spring.blog.springbootblogapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

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
        Post post = postRepository.getById(id);
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