package com.ibs.customermanagement.web_tier.handlers.exceptions;

public class WS_Exception extends Exception {

    public WS_Exception() {
        super();
    }
    public WS_Exception(String message, Throwable cause) { super(message, cause); }
    public WS_Exception(String message) {
        super(message);
    }
    public WS_Exception(Throwable cause) {
        super(cause);
    }

}
