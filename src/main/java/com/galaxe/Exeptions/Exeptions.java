package com.galaxe.Exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Exeptions {

  @ExceptionHandler(UserAlredyExisted.class)
  public ResponseEntity<String> UserAlredyExisted(UserAlredyExisted ex) {
    return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(UserNotFoundExceptions.class)
  public ResponseEntity<String> UserNotFound(UserNotFoundExceptions ex) {
    return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
