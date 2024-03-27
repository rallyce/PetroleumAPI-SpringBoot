package com.rallyce.Petroleum_Inventario.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handlerArgumentException(IllegalArgumentException ex){
        return new ResponseEntity<String>("A required field is empty", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handlerRuntimeExcetion(RuntimeException ex){
        return new ResponseEntity<String>("The username has already been taken", HttpStatus.BAD_GATEWAY);
    }
}
