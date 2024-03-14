package com.galaxe.Exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationExeptionHandler {
  @ResponseStatus(HttpStatus.CONFLICT)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public String ExceptionHandlerforInputFields(MethodArgumentNotValidException ex) {
    return ex.getBindingResult().getFieldError().getDefaultMessage();
  }
}
