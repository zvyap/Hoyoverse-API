package com.zvyap.hoyoapi.exception;

//may trigger when uid or some data is wrong
public class SomethingWhenWrongException extends HoyoverseAPIRetCodeException {

    public SomethingWhenWrongException(int retcode, String message) {
        super(retcode, message);
    }
}
