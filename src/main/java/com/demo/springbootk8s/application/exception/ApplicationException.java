package com.demo.springbootk8s.application.exception;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class ApplicationException extends RuntimeException {

    @Getter
    @Setter
    private String message;

    @Setter
    private List<String> errors = new ArrayList<>();

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(String message, String error) {
        super(message);
        this.errors.add(error);
    }

    public ApplicationException(String message, List<String> errors) {
        super(message);
        this.errors.addAll(errors);
    }

    public List<String> getErrors() {
        return this.errors;
    }
}
