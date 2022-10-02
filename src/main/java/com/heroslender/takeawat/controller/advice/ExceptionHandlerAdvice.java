package com.heroslender.takeawat.controller.advice;

import com.heroslender.takeawat.response.ResponseEntityError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseEntityError> handleException(IllegalArgumentException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ResponseEntityError(0, e.getMessage()));
    }
}
