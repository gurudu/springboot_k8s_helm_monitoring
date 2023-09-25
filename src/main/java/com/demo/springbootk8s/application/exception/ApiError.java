package com.demo.springbootk8s.application.exception;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
public class ApiError {

    private  String message;
    private List<String> errors = new ArrayList<>();

    public ApiError(String message){
        this.message = message;
    }

    public ApiError(String message, String error){
        this.message = message;
        this.errors.add(error);
    }

    public ApiError(String message,List<String> errors){
        this.message = message;
        this.errors.addAll(errors);
    }

}
