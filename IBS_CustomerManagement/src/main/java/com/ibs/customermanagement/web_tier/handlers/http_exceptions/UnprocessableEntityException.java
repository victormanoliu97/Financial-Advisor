package com.ibs.customermanagement.web_tier.handlers.http_exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends RuntimeException {

    public UnprocessableEntityException() {
        super();
    }
    public UnprocessableEntityException(String message, Throwable cause) {
        super(message, cause);
    }
    public UnprocessableEntityException(String message) {
        super(message);
    }
    public UnprocessableEntityException(Throwable cause) {
        super(cause);
    }
}
