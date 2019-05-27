package com.ibs.customermanagement.web_tier.handlers.exceptions;

public class WSException extends Exception {

    public WSException() {
        super();
    }
    public WSException(String message, Throwable cause) { super(message, cause); }
    public WSException(String message) {
        super(message);
    }
    public WSException(Throwable cause) {
        super(cause);
    }

}
