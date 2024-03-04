package com.zvyap.hoyoapi;

import com.zvyap.hoyoapi.annotation.OnlyAPI;
import com.zvyap.hoyoapi.exception.HoyoverseAPIException;
import com.zvyap.hoyoapi.exception.HoyoverseLoginFailedException;
import com.zvyap.hoyoapi.exception.HoyoverseRequestFailedException;
import com.zvyap.hoyoapi.exception.InvalidParameterException;
import com.zvyap.hoyoapi.exception.SomethingWhenWrongException;
import com.zvyap.hoyoapi.http.ContentType;
import com.zvyap.hoyoapi.http.HttpMethod;
import com.zvyap.hoyoapi.http.JsonBodyHandler;
import com.zvyap.hoyoapi.http.JsonPublisher;
import com.zvyap.hoyoapi.response.*;
import com.zvyap.hoyoapi.util.Utils;
import lombok.Getter;
import lombok.extern.java.Log;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@Log
public class HoyoverseAPI {
    //Allow function of tryToAllowRestrictedHeader, this is not required anymore.
    private static final boolean CRACK_HEADER = false;
    private static final APILocale DEFAULT_LOCALE = APILocale.EN_US;

    private static HoyoverseAPI globalInstance;

    @Nullable
    public static HoyoverseAPI getGlobalInstance() {
        return globalInstance;
    }

    @NotNull
    public static HoyoverseAPI buildGlobalInstance(@NotNull APIEnvironment environment) {
        return buildGlobalInstance(environment, null);
    }

    @NotNull
    public static HoyoverseAPI buildGlobalInstance(@NotNull APIEnvironment environment, @Nullable APILocale locale) {
        if (globalInstance == null) {
            globalInstance = new HoyoverseAPI(environment, locale);
        }
        return globalInstance;
    }

    @Getter
    private final HttpClient httpClient;
    @Getter
    private final APIEnvironment environment;
    @Getter
    private final String lang;
    @Getter
    private boolean isHeaderSafe;

    /**
     * @param environment APIEnvironment
     */
    public HoyoverseAPI(@NotNull APIEnvironment environment) {
        this(environment, null);
    }


    /**
     * @param environment APIEnvironment
     * @param locale      APILocale
     */
    public HoyoverseAPI(@NotNull APIEnvironment environment, @Nullable APILocale locale) {
        tryToAllowRestrictedHeader();
        this.httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .cookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_NONE))
                .build();
        this.environment = environment;
        if (locale == null) {
            locale = DEFAULT_LOCALE;
        }
        this.lang = locale.getValue();

    }

    private void tryToAllowRestrictedHeader() {
        if (!CRACK_HEADER) {
            return; //NOP
        }
        if (Runtime.version().feature() < 11) {
            throw new UnsupportedOperationException("Invalid java version " + Runtime.version().feature() + " [Only Java 11+ is supported]");
        }

        List<String> headerShouldAllow = List.of("Host", "Connection");
        if (Runtime.version().feature() == 11) { //12+
            try { //Not working on most case
                Class<?> clazz = Class.forName("jdk.internal.net.http.common.Utils");
                Field field = clazz.getDeclaredField("DISALLOWED_HEADERS_SET");
                field.setAccessible(true);
                Set<String> headers = (Set<String>) field.get(null);
                field.setInt(field, field.getModifiers() & ~Modifier.FINAL);

                Set<String> newHeaders = new TreeSet<>(headers);
                field.set(null, newHeaders);
                isHeaderSafe = true;
            } catch (Exception e) {
                log.warning("Some request might break due to restricted header");
            }
            return;
        }

        for (String h : headerShouldAllow) {
            System.setProperty("jdk.httpclient.allowRestrictedHeaders", h);
        }

        HttpRequest.Builder builder = HttpRequest.newBuilder().uri(URI.create("http://localhost"));

        try {
            for (String h : headerShouldAllow) { //valid
                builder.header(h, "justtesting");
            }
            isHeaderSafe = true;
        } catch (Exception e) {
            log.warning("Some request might break due to restricted header");
        }
    }

    /**
     * Get game roles with some filter
     *
     * @param token HoyoToken
     * @return A list of all game roles in this account
     */
    @NotNull
    public List<HoyoGameRole> getGameRoles(@NotNull HoyoToken token) {
        return getGameRoles(token, (GameType) null);
    }

    /**
     * Get game roles with some filter
     *
     * @param token HoyoToken
     * @param type  GameType
     * @return A list of game roles of the game type with all region
     */
    @NotNull
    public List<HoyoGameRole> getGameRoles(@NotNull HoyoToken token, @Nullable GameType type) {
        return Utils.ifNullGetEmptyList(Utils.getUserGameRoles(this, token, type, null).body().get().getData(), HoyoGetUserGameRolesResponse.Data::getRoles);
    }

    /**
     * Get game role by UID with GameType filter
     *
     * @param token HoyoToken
     * @param type  GameType
     * @param uid   In game UID
     * @return Game role information
     */
    @Nullable
    public HoyoGameRole getGameRoles(@NotNull HoyoToken token, @Nullable GameType type, String uid) {
        for (HoyoGameRole role : getGameRoles(token, type)) {
            if (role.getGameUid().equals(uid)) {
                return role;
            }
        }
        return null;
    }

    /**
     * Get game role by UID
     *
     * @param token HoyoToken
     * @param uid   In game UID
     * @return Game role information
     */
    @Nullable
    public HoyoGameRole getGameRoles(@NotNull HoyoToken token, @Nullable String uid) { //uid null will return null
        return getGameRoles(token, null, uid);
    }

    /**
     * Get game role with filter
     *
     * @param token  HoyoToken
     * @param type   GameType
     * @param region ServerRegion
     * @return Game role information
     */
    @Nullable
    public HoyoGameRole getGameRoles(@NotNull HoyoToken token, @Nullable GameType type, @Nullable ServerRegion region) {
        for (HoyoGameRole role : getGameRoles(token, type)) {
            if (region == null || region.match(type, role.getRegion())) {
                return role;
            }
        }
        return null;
    }

    /**
     * Get game role with filter
     *
     * @param token  HoyoToken
     * @param region ServerRegion
     * @return
     */
    @NotNull
    public List<HoyoGameRole> getGameRoles(@NotNull HoyoToken token, @Nullable ServerRegion region) {
        List<HoyoGameRole> roles = new ArrayList<>();
        for (HoyoGameRole role : getGameRoles(token)) {
            if (region == null || region.match(role.getRegion())) {
                roles.add(role);
            }
        }
        return roles;
    }

    /**
     * Get user forum profile via account Id
     * <p>
     * WARN: This request is fat, be careful
     *
     * @param accountId You can get this in url when you visit a user profile in forum, same as {@link HoyoToken#getLtuid()}
     * @return
     */
    @NotNull
    public HoyoGetForumFullUserResponse getForumUser(@NotNull String accountId) {
        return Utils.getForumUser(this, accountId).body().get();
    }

    /**
     * Get user forum profile via token object
     * <p>
     * WARN: This request is fat, be careful
     *
     * @param token HoyoToken, see also {@link this#getForumUser(String)}
     * @return
     */
    @NotNull
    public HoyoGetForumFullUserResponse getForumUser(@NotNull HoyoToken token) {
        return Utils.getForumUser(this, token.getLtuid()).body().get();
    }

    /**
     * Get account information of this token
     * Note: Some sensitive data such as: [username, email] will be blur
     * <p>
     * For example: abc*****@gmail.com, ab****g
     *
     * @param token
     * @return
     */
    @NotNull
    public HoyoGetUserAccountInfoResponse getAccountInfo(HoyoToken token) {
        return makeRequest(token,
                buildRequest(URI.create(getEnvironment().getAccountAPIConstant().getUserAccountInfoEndpoint()),
                        HttpMethod.GET, ContentType.HOYO_API),
                JsonBodyHandler.of(HoyoGetUserAccountInfoResponse.class)).body().get();
    }

    /**
     * Get game basic details, such as: icon, name(follow {@link APILocale})
     *
     * @return A list of GameDetails
     */
    @NotNull
    @OnlyAPI(env = APIEnvironment.OVERSEA)
    public List<HoyoGamesDetailsResponse.GameDetails> getGameDetails() {
        return makeRequest(null,
                buildRequest(URI.create(APIEnvironment.OVERSEA.getAccountAPIConstant().getGamesDetailsEndpoint()),
                        HttpMethod.GET, ContentType.HOYO_API,
                        "x-rpc-client_type", "4",
                        "x-rpc-language", lang),
                JsonBodyHandler.of(HoyoGamesDetailsResponse.class)).body().get().getData().getGameList();
    }

    /**
     * Get game basic details, such as: icon, name(follow {@link APILocale})
     *
     * @param type The GameType for filter game you want
     * @return GameDetails
     */
    @NotNull
    @OnlyAPI(env = APIEnvironment.OVERSEA)
    public HoyoGamesDetailsResponse.GameDetails getGameDetails(GameType type) {
        for (HoyoGamesDetailsResponse.GameDetails details : getGameDetails()) {
            if (details.getId().equals(String.valueOf(type.getGameId()))) {
                return details;
            }
        }
        return null; //Should not be happened if game already released
    }

    /**
     * Get Miyoushe tools navigators
     *
     * @param type The GameType for filter game you want
     * @return GameDetails
     */
    @NotNull
    @OnlyAPI(env = APIEnvironment.CHINA)
    public MYSNavigatorsResponse.Data getNavigators(GameType type) {
        return makeRequest(null,
                buildRequest(URI.create(APIEnvironment.CHINA.getAccountAPIConstant().getNavigatorsEndpoint()),
                        HttpMethod.POST, ContentType.HOYO_API,
                        JsonPublisher.of(Map.of("game_id", type.getGameId(), "types", List.of(4, 5))),
                        "x-rpc-client_type", "4"),
                JsonBodyHandler.of(MYSNavigatorsResponse.class)).body().get().getData();
    }

    @NotNull
    public HttpRequest.Builder buildRequest(@NotNull URI uri, @NotNull HttpMethod method, @NotNull ContentType contentType, String... headers) {
        return buildRequest(uri, method, contentType, null, headers);
    }

    @NotNull
    public HttpRequest.Builder buildRequest(@NotNull URI uri, @NotNull HttpMethod method, @NotNull ContentType contentType, @Nullable HttpRequest.BodyPublisher bodyPublisher, String... headers) {
        HttpRequest.Builder builder = HttpRequest.newBuilder(uri)
                .header("Accept", contentType.toString());

        headers(builder, headers);
        if (method == HttpMethod.GET) {
            builder.GET();
        } else if (method == HttpMethod.DELETE) {
            builder.DELETE();
        } else {
            builder.method(method.name(), bodyPublisher);
        }
        return builder;
    }

    @NotNull
    public <T> HttpResponse<T> makeRequest(@Nullable HoyoToken token, @NotNull HttpRequest.Builder request, @NotNull HttpResponse.BodyHandler<T> responseBodyHandler) {
        if (token != null) {
            request.header("Cookie", token.toCookieString());
        }
        try {
            HttpResponse<T> response = httpClient.send(request.build(), responseBodyHandler);
            if (token != null && response.body() instanceof Supplier && ((Supplier) response.body()).get() instanceof HoyoAPIResponse) {
                HoyoAPIResponse r = (HoyoAPIResponse) ((Supplier<?>) response.body()).get();
                switch (r.getRetcode()) {
                    case -100:
                        throw new HoyoverseLoginFailedException(r.getRetcode(), r.getMessage());
                    case -502:
                        throw new SomethingWhenWrongException(r.getRetcode(), r.getMessage());
                    case 1002:
                        throw new InvalidParameterException(r.getRetcode(), r.getMessage());
                }
            }
            return response;
        } catch (IOException | InterruptedException e) {
            throw new HoyoverseRequestFailedException(e);
        }
    }

    @NotNull
    public <T> T makeRequest(@Nullable HoyoToken token, @NotNull HttpRequest.Builder request, @NotNull Class<T> responseClass) {
        return makeRequest(token, request, JsonBodyHandler.of(responseClass)).body().get();
    }

    @NotNull
    public <T> CompletableFuture<HttpResponse<T>> makeRequestAsync(@NotNull HttpRequest request, @NotNull HttpResponse.BodyHandler<T> responseBodyHandler) {
        return httpClient.sendAsync(request, responseBodyHandler);
    }

    private HttpRequest.Builder headers(HttpRequest.Builder builder, String... params) {
        if (ObjectUtils.isEmpty(params)) {
            return builder;
        }
        if (params.length == 0 || params.length % 2 != 0) {
            throw new IllegalArgumentException(String.format("Wrong number, %d, of parameters", params.length));
        }
        for (int i = 0; i < params.length; i += 2) {
            String name = params[i];
            String value = params[i + 1];
            try {
                builder.header(name, value);
            } catch (Exception e) {
                if (isHeaderSafe()) { //Not header restricted problem
                    throw new HoyoverseAPIException(e);
                } else {
                    log.warning("Could not add restricted header - " + name);
                    log.fine(ExceptionUtils.getStackTrace(e));
                }
            }
        }
        return builder;
    }
}
