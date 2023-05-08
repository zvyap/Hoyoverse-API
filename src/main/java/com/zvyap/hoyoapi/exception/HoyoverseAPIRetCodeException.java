package com.zvyap.hoyoapi.exception;

public class HoyoverseAPIRetCodeException extends HoyoverseAPIException {
    private final int retcode;

    public HoyoverseAPIRetCodeException(int retcode, String message) {
        super(message);
        this.retcode = retcode;
    }

    public HoyoverseAPIRetCodeException(int retcode, String message, Throwable cause) {
        super(message, cause);
        this.retcode = retcode;
    }

    public int getRetcode() {
        return retcode;
    }
}
