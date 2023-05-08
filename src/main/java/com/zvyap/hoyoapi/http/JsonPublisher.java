package com.zvyap.hoyoapi.http;


import com.zvyap.hoyoapi.util.JsonUtils;
import org.jetbrains.annotations.NotNull;

import java.net.http.HttpRequest;
import java.nio.charset.Charset;

public class JsonPublisher {
    public static HttpRequest.BodyPublisher of(@NotNull Object obj) {
        return of(obj, Charset.defaultCharset());
    }

    public static HttpRequest.BodyPublisher of(@NotNull Object obj, @NotNull Charset charset) {
        return HttpRequest.BodyPublishers.ofString(JsonUtils.toJsonSafe(obj), charset);
    }
}
