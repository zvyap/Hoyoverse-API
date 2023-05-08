package com.zvyap.hoyoapi.exception;

public class HoyoverseHttpRequestException extends HoyoverseAPIException {
    private final int code;

    public HoyoverseHttpRequestException(int code) {
        super("Failed to request Hoyoverse API - " + code);
        this.code = code;
    }

    public HoyoverseHttpRequestException(int code, String message) {
        super(message);
        this.code = code;
    }

    public HoyoverseHttpRequestException(int code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public HoyoverseHttpRequestException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
