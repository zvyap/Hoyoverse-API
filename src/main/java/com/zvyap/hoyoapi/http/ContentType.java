package com.zvyap.hoyoapi.http;

import lombok.Getter;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Getter
public class ContentType {
    public static final ContentType JSON = new ContentType("application/json", StandardCharsets.UTF_8);
    public static final ContentType TEXT_HTML = new ContentType("text/html", StandardCharsets.ISO_8859_1);
    public static final ContentType TEXT_PLAIN = new ContentType("text/plain", StandardCharsets.ISO_8859_1);
    public static final ContentType WILDCARD = new ContentType("*/*", (Charset) null);

    public static final ContentType HOYO_API = new ContentType("application/json, text/plain, */*", StandardCharsets.UTF_8);

    private final String type;
    private final Charset charset;

    public ContentType(String type, Charset charset) {
        this.type = type;
        this.charset = charset;
    }

    @Override
    public String toString() {
        final StringBuilder buf = new StringBuilder(64); //http content-type limit
        buf.append(this.type);
        if (this.charset != null) {
            buf.append("; charset=");
            buf.append(this.charset.name());
        }
        return buf.toString();
    }
}
