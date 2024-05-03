package com.br.joel.Project.Ws.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.time.Instant;

@RestControllerAdvice
public class GlobalHandler {



    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<FieldMessage> notFoundExceptionHandler(HttpServletRequest request, NotFoundException e ){
        FieldMessage message = new FieldMessage();

        message.setPath(request.getRequestURI());
        message.setMessage(e.getMessage());
        message.setTimestamp(Instant.now());
        message.setError(HttpStatus.NOT_FOUND.toString());
        message.setError("Object Not Found");

        return ResponseEntity.ok(message);
    }
}
