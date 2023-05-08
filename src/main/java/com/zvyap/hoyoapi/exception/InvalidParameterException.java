package com.zvyap.hoyoapi.exception;

public class InvalidParameterException extends HoyoverseAPIRetCodeException {
    public InvalidParameterException(int retcode, String message) {
        super(retcode, message);
    }
}
