package com.zvyap.hoyoapi.exception;

public class HoyoverseAPIMissingException extends HoyoverseAPIException {
    public HoyoverseAPIMissingException(String missing) {
        super("Missing API - " + missing);
    }
}
