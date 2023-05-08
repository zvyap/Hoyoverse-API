package com.zvyap.hoyoapi.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JsonUtils {
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @NotNull
    public static ObjectMapper getObjectMapper() {
        return OBJECT_MAPPER;
    }

    @Nullable
    public static <T> T fromJson(@Nullable String json, @NotNull Class<T> clazz) throws JsonProcessingException {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        return OBJECT_MAPPER.readValue(json, clazz);
    }

    @Nullable
    public static <T> T fromJsonSafe(@Nullable String json, @NotNull Class<T> clazz) {
        try {
            return fromJson(json, clazz);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static String toJson(@NotNull Object obj) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(obj);
    }

    public static String toJsonSafe(@NotNull Object obj) {
        try {
            return toJson(obj);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
