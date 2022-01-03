package com.spring.blog.springbootblogapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "comments")
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    int id;

    @Column(name = "body")
    String body;

    @Column(name = "date")
    Date date;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    Post post;



}
