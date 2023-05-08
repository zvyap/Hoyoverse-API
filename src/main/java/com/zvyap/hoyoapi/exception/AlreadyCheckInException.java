package com.zvyap.hoyoapi.exception;

public class AlreadyCheckInException extends HoyoverseAPIRetCodeException{
    public AlreadyCheckInException(int retcode, String message) {
        super(retcode, message);
    }
}
