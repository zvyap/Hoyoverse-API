package com.zvyap.hoyoapi.exception;

public class HoyoverseAPIException extends RuntimeException {
    public HoyoverseAPIException() {
    }

    public HoyoverseAPIException(String message) {
        super(message);
    }

    public HoyoverseAPIException(Throwable cause) {
        super(cause);
    }

    public HoyoverseAPIException(String message, Throwable cause) {
        super(message, cause);
    }
}
