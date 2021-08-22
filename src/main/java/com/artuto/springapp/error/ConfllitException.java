package com.artuto.springapp.error;

import org.springframework.http.HttpStatus;

public class ConfllitException extends ApiBaseException {

    public ConfllitException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }
}
