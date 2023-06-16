package com.innter.ms.people.utils;

import com.innter.ms.people.exception.BadRequestInnter;
import com.innter.ms.people.exception.ErrorDto;
import com.innter.ms.people.exception.InternalServerErrorInnter;
import com.innter.ms.people.exception.NotFoundInnter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = BadRequestInnter.class)//Error 400
    public ResponseEntity<ErrorDto> noRequest(BadRequestInnter error) {
        ErrorDto errorDto = ErrorDto.builder().code(error.getCode()).message(error.getMessage()).build();
        return new ResponseEntity<>(errorDto, error.getStatus());
    }

    @ExceptionHandler(value = NotFoundInnter.class)//Error 404
    public ResponseEntity<ErrorDto> noFound(NotFoundInnter error) {
        ErrorDto errorDto = ErrorDto.builder().code(error.getCode()).message(error.getMessage()).build();
        return new ResponseEntity<>(errorDto, error.getStatus());
    }

    @ExceptionHandler(value = InternalServerErrorInnter.class)//Error 500
    public ResponseEntity<ErrorDto> noServidor(InternalServerErrorInnter error) {
        ErrorDto errorDto = ErrorDto.builder().code(error.getCode()).message(error.getMessage()).build();
        return new ResponseEntity<>(errorDto, error.getStatus());
    }
}
