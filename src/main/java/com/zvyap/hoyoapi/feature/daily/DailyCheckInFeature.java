package com.zvyap.hoyoapi.feature.daily;

import com.zvyap.hoyoapi.GameAPIConstant;
import com.zvyap.hoyoapi.GameType;
import com.zvyap.hoyoapi.HoyoToken;
import com.zvyap.hoyoapi.HoyoverseAPI;
import com.zvyap.hoyoapi.exception.AlreadyCheckInException;
import com.zvyap.hoyoapi.exception.GameProfileNotFoundException;
import com.zvyap.hoyoapi.exception.HoyoverseHttpRequestException;
import com.zvyap.hoyoapi.http.ContentType;
import com.zvyap.hoyoapi.http.HttpMethod;
import com.zvyap.hoyoapi.http.JsonBodyHandler;
import com.zvyap.hoyoapi.http.JsonPublisher;
import com.zvyap.hoyoapi.response.HoyoAPIResponse;
import com.zvyap.hoyoapi.response.HoyoDailyCheckInInfoResponse;
import com.zvyap.hoyoapi.response.HoyoDailyCheckInRewardResponse;
import com.zvyap.hoyoapi.response.HoyoDailyCheckInSignResponse;
import com.zvyap.hoyoapi.util.HttpUtils;
import org.jetbrains.annotations.NotNull;

import java.net.http.HttpResponse;
import java.util.Map;
import java.util.function.Supplier;

public class DailyCheckInFeature {

    private HoyoverseAPI api;

    public DailyCheckInFeature(HoyoverseAPI api) {
        this.api = api;
    }

    private <T> T fetchDailyEndpoint(HoyoToken token, HttpMethod method, GameType type, String endpoint, Class<T> responseClass) {
        GameAPIConstant constant = api.getEnvironment().getAPIConstant(type);
        Map<String, String> data = Map.of("act_id", constant.getDailyCheckInActId(), "lang", api.getLang());
        HttpResponse<Supplier<T>> response =  api.makeRequest(token,
                api.buildRequest(
                        HttpUtils.createURI(constant.getDailyCheckInApiEndpoint(), endpoint, data),
                        method,
                        ContentType.HOYO_API,
                        method == HttpMethod.POST ? JsonPublisher.of(data) : null,
                        "Accept-Language", "en-US,en;q=0.5",
                        "Origin", "https://webstatic-sea.mihoyo.com", "Connection", "keep-alive",
                        "Referer", "https://webstatic-sea.mihoyo.com/ys/event/signin-sea/index.html?act_id={config[\"ACT_ID\"]}&lang=en-us",
                        "Cache-Control", "max-age=0"),
                new JsonBodyHandler<>(responseClass));

        if(response.statusCode() != 200) {
            throw new HoyoverseHttpRequestException(response.statusCode());
        }

        T body = response.body().get();
        if(body instanceof HoyoAPIResponse) {
            HoyoAPIResponse r = (HoyoAPIResponse) body;
            switch (r.getRetcode()) {
                case -5003:
                    throw new AlreadyCheckInException(r.getRetcode(), r.getMessage());
                case -10002:
                    throw new GameProfileNotFoundException(r.getRetcode(),r.getMessage());
            }
        }

        return body;
    }

    public HoyoDailyCheckInInfoResponse getDailyInfo(@NotNull GameType type, @NotNull HoyoToken token) {
        return fetchDailyEndpoint(token, HttpMethod.GET, type, "info", HoyoDailyCheckInInfoResponse.class);
    }

    public HoyoDailyCheckInSignResponse signDaily(@NotNull GameType type, @NotNull HoyoToken token) {
        return fetchDailyEndpoint(token, HttpMethod.POST, type, "sign", HoyoDailyCheckInSignResponse.class);
    }

    public HoyoDailyCheckInRewardResponse getAllReward(@NotNull GameType type) {
        return fetchDailyEndpoint(null, HttpMethod.GET, type, "home", HoyoDailyCheckInRewardResponse.class);
    }
}
