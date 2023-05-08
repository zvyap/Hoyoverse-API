package com.zvyap.hoyoapi.util;

import com.zvyap.hoyoapi.APIEnvironment;
import com.zvyap.hoyoapi.GameType;
import com.zvyap.hoyoapi.HoyoToken;
import com.zvyap.hoyoapi.HoyoverseAPI;
import com.zvyap.hoyoapi.http.ContentType;
import com.zvyap.hoyoapi.http.HttpMethod;
import com.zvyap.hoyoapi.http.JsonBodyHandler;
import com.zvyap.hoyoapi.response.HoyoGetForumFullUserResponse;
import com.zvyap.hoyoapi.response.HoyoGetUserAccountInfoResponse;
import com.zvyap.hoyoapi.response.HoyoGetUserGameRolesResponse;

import java.net.URI;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class Utils {
    public static final String UNKNOWN = "UNKNOWN";

    public static HttpResponse<Supplier<HoyoGetUserGameRolesResponse>> getUserGameRoles(HoyoverseAPI api, HoyoToken token, GameType type, Map<String, String> additionalParams) { //params: lang, game_biz, sLangKey, region
        if(additionalParams == null) {
            additionalParams = new HashMap<>();
        }
        if(type != null) {
            additionalParams.put("game_biz", api.getEnvironment().getAPIConstant(type).getGameBiz());
        }
        additionalParams.put("lang", api.getLang());
        additionalParams.put("sLangKey", api.getLang()); //IDK what this doing
        return api.makeRequest(token, api.buildRequest(HttpUtils.createURI(api.getEnvironment().getAccountAPIConstant().getUserGameRoleEndpoint(), null, additionalParams),
                HttpMethod.GET, ContentType.HOYO_API, null), JsonBodyHandler.of(HoyoGetUserGameRolesResponse.class));
    }

    public static HttpResponse<Supplier<HoyoGetForumFullUserResponse>> getForumUser(HoyoverseAPI api, String accountId) {
        Map<String, String> additionalParams = new HashMap<>();
        additionalParams.put("uid", accountId);
        additionalParams.put("gids", "2");

        String[] headers = null;
        if(api.getEnvironment() == APIEnvironment.CHINA) {
            headers = new String[] {"Referer","https://www.miyoushe.com/"};
        }

        return api.makeRequest(null,
                api.buildRequest(HttpUtils.createURI(api.getEnvironment().getAccountAPIConstant().getForumFullUserInfoEndpoint(), null, additionalParams),
                        HttpMethod.GET, ContentType.HOYO_API, headers),
                JsonBodyHandler.of(HoyoGetForumFullUserResponse.class));
    }

    public static <T> List<T> ifNullGetEmptyList(List<T> list) {
        if(list == null) {
            return new ArrayList<>(); //Not using Collections.emptyList() so user can edit the list;
        }
        return list;
    }

    public static <O, T> List<T> ifNullGetEmptyList(O preCheck, Function<O, List<T>> listSupplier) {
        if(preCheck == null || listSupplier.apply(preCheck) == null) {
            return new ArrayList<>(); //Not using Collections.emptyList() so user can edit the list;
        }
        return listSupplier.apply(preCheck);
    }
}
