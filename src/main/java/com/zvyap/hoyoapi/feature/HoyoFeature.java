package com.zvyap.hoyoapi.feature;

import com.zvyap.hoyoapi.HoyoverseAPI;

public class HoyoFeature {
    protected final HoyoverseAPI api;

    public HoyoFeature(HoyoverseAPI api) {
        this.api = api;
    }

    public HoyoverseAPI getAPI() {
        return api;
    }
}
