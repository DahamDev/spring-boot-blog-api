package com.spring.blog.springbootblogapi.payload;

import com.spring.blog.springbootblogapi.entity.Post;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
public class CommentDto {
    int id;
    int body;
    PostDto postDto;
    Date date;
}
