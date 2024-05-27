package com.cidadeLimpa.cidadeLimpa.advice;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cidadeLimpa.cidadeLimpa.exception.CaminhaoNotFound;
import com.cidadeLimpa.cidadeLimpa.exception.ColetaNotFound;
import com.cidadeLimpa.cidadeLimpa.exception.LixeiraNotFound;
import com.cidadeLimpa.cidadeLimpa.exception.LixeiraParaColetaNotFound;
import com.cidadeLimpa.cidadeLimpa.exception.RotaNotFound;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException error) {
        Map<String, String> errorMap = new HashMap<>();
        List<FieldError> campos = error.getBindingResult().getFieldErrors();

        for(FieldError campo : campos) {
            errorMap.put(campo.getField(), campo.getDefaultMessage());
        }

        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(LixeiraNotFound.class)
    public Map<String, String> handleLixeiraNotFound(LixeiraNotFound error) {
        Map<String, String> errorMap = new HashMap<>();
        String menssagem = error.getMessage();

        errorMap.put("error", menssagem);

        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CaminhaoNotFound.class)
    public Map<String, String> handleCaminhaoNotFound(CaminhaoNotFound error) {
        Map<String, String> errorMap = new HashMap<>();
        String menssagem = error.getMessage();

        errorMap.put("error", menssagem);

        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ColetaNotFound.class)
    public Map<String, String> handleColetaNotFound(ColetaNotFound error) {
        Map<String, String> errorMap = new HashMap<>();
        String menssagem = error.getMessage();

        errorMap.put("error", menssagem);

        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(LixeiraParaColetaNotFound.class)
    public Map<String, String> handleLixeiraParaColetaNotFound(LixeiraParaColetaNotFound error) {
        Map<String, String> errorMap = new HashMap<>();
        String menssagem = error.getMessage();

        errorMap.put("error", menssagem);

        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RotaNotFound.class)
    public Map<String, String> handleRotaNotFound(RotaNotFound error) {
        Map<String, String> errorMap = new HashMap<>();
        String menssagem = error.getMessage();

        errorMap.put("error", menssagem);

        return errorMap;
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public Map<String, String> handleIntegrityViolation(){

        Map<String, String> errorMap = new HashMap<>();

        errorMap.put("erro", "Usuário já cadastrado!");

        return errorMap;

    }
}
