package com.zvyap.hoyoapi.util;


import org.apache.commons.lang3.StringUtils;

import java.net.URI;
import java.net.http.HttpHeaders;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpUtils {
    public static final Pattern CHARSET_PATTERN = Pattern
            .compile("(?<=charset=)[^;]*");
    public static Charset charsetFrom(HttpHeaders headers) {
        String type = headers.firstValue("Content-type")
                .orElse("text/html; charset=utf-8");
        int i = type.indexOf(";");
        if (i >= 0) type = type.substring(i+1);
        Matcher m = CHARSET_PATTERN.matcher(type);
        if (m.find()) {
            String charset = m.group().trim();
            try{
                return Charset.forName(charset);
            }catch (Exception e) {
                charset = charset.toUpperCase(Locale.ENGLISH);
                try{
                    return Charset.forName(charset);
                }catch (Exception ex) {
                }
            }
        }
        return null;
    }

    public static URI createURI(String uri, String additional, Map<String, String> params) {
        StringBuilder builder = new StringBuilder(uri);
        if(!StringUtils.isEmpty(additional)) {
            if(!additional.startsWith("/") && !uri.endsWith("/")) {
                builder.append("/");
            }
            builder.append(additional);
        }
        if(!params.isEmpty()) {
            builder.append("?");
        }
        for(Map.Entry<String, String> entry : params.entrySet()){
            builder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        builder.setLength(builder.length() - 1);
        return URI.create(builder.toString());
    }
}
