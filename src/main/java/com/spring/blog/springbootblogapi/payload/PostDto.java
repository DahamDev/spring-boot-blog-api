package com.spring.blog.springbootblogapi.payload;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Column;

@Getter
@Setter
public class PostDto {

    private int id;
    private String title;
    private String description;
    private String content;




}
