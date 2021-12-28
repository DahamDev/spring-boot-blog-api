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
    int body;

    @ManyToOne
    @Column(name = "post")
    Post post;

    @Column(name = "date")
    Date date;


    public Comment(int id, int body, Date date) {
        this.id = id;
        this.body = body;
        this.date = date;
    }


}
