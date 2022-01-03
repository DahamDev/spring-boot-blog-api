package com.spring.blog.springbootblogapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionDetails {

    String details;
    String request;
    String reason;
}
