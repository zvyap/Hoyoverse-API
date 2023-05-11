package com.zvyap.hoyoapi.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
public class HoyoAPIResponse {
    @JsonProperty("message")
    protected String message;

    @JsonProperty("retcode")
    protected int retcode;

    public String getMessage() {
        return message;
    }

    public int getRetcode() {
        return retcode;
    }

    public boolean isSuccess() {
        return retcode >= 0;
    }
}
