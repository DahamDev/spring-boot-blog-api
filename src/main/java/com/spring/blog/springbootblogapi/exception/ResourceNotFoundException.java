package com.spring.blog.springbootblogapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceNotFoundException extends RuntimeException{

    private String fieldName;
    private String reason;

    public ResourceNotFoundException( String fieldName, String reason) {
        super(String.format("your request cannot proceed " + reason +" " + fieldName));
        this.fieldName = fieldName;
        this.reason = reason;
    }
}
