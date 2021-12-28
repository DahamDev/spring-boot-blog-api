package com.spring.blog.springbootblogapi.controller;

import com.spring.blog.springbootblogapi.entity.Post;
import com.spring.blog.springbootblogapi.payload.PostDto;
import com.spring.blog.springbootblogapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> addPost(@RequestBody PostDto postDto){

        return (ResponseEntity.status(HttpStatus.CREATED).body(postService.addPost(postDto)));
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getPosts(){
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") int id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @GetMapping("/page")
    public ResponseEntity<List<PostDto>> getPostperPage(
            @RequestParam (name = "pagenumber",defaultValue="0",required = false ) int pagenumber,
            @RequestParam (name ="pagesize" , defaultValue = "2" , required = false) int pagesize
    ){
        return ResponseEntity.ok(postService.getPostsPerPage(pagenumber,pagesize));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto , @PathVariable(name = "id") int id  ){
        return ResponseEntity.ok(postService.updatePost(postDto,id));
    }


}
