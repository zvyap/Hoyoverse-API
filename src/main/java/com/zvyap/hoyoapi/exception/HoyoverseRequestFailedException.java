package com.zvyap.hoyoapi.exception;

public class HoyoverseRequestFailedException extends HoyoverseAPIException {
    public HoyoverseRequestFailedException(String message) {
        super(message);
    }

    public HoyoverseRequestFailedException(Throwable cause) {
        super(cause);
    }

    public HoyoverseRequestFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
