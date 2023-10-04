package com.zvyap.hoyoapi;

public class HoyoTokenV2 extends HoyoToken {
    public HoyoTokenV2(String ltuid, String ltoken) {
        super(ltuid, ltoken);
    }

    @Override
    String toCookieString() {
        return new StringBuilder("ltoken_v2=").append(ltoken).append("; ltuid_v2=").append(ltuid).toString();
    }
}
