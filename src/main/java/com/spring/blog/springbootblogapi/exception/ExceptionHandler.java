package com.spring.blog.springbootblogapi.exception;

import com.spring.blog.springbootblogapi.entity.ExceptionDetails;
import javafx.scene.control.TableView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<ExceptionDetails> ResourceNotFoundExceptionHandler(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDetails(webRequest.getDescription(true),resourceNotFoundException.getMessage(),""));
    }
}
