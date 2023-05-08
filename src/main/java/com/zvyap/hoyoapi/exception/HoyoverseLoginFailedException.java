package com.zvyap.hoyoapi.exception;

public class HoyoverseLoginFailedException extends HoyoverseAPIRetCodeException{
    public HoyoverseLoginFailedException(int retcode, String message) {
        super(retcode, message);
    }
}
