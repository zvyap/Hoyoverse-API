package com.zvyap.hoyoapi;

import java.util.List;

//Followed https://bbs-api-os-static.hoyolab.com/community/misc/wapi/langs?lang2022=true
public enum APILocale {
    ZH_CN("简体中文","zh-cn","简","zh-cn","CHS"),
    ZH_TW("繁體中文","zh-tw","繁","zh-tw","CHT"),
    DE("Deutsch","de-de","DE","de-de","DE"),
    EN_US("English","en-us","EN","en-us","EN"),
    ES("Español","es-es","ES","es-es","ES"),
    FR("Français","fr-fr","FR","fr-fr","FR"),
    ID("Indonesia","id-id","ID","id-id","ID"),
    IT("Italiano","it-it","IT","it-it","IT"),
    JP("日本語","ja-jp","JP","ja-jp","JP","JA"),
    KR("한국어","ko-kr","KR","ko-kr","KR","KO"),
    PT("Português","pt-pt","PT","pt-pt","PT"),
    RU("Pусский","ru-ru","RU","ru-ru","RU"),
    TH("ภาษาไทย","th-th","TH","th-th","TH"),
    TR("Türkçe","tr-tr","TR","tr-tr","TR"),
    VI_VN("Tiếng Việt","vi-vn","VN","vi-vn","VN","VI");

    private final String name;
    private final String value;
    private final String label;
    private final List<String> alias;

    APILocale(String name, String value, String label, String... alias) {
        this.name = name;
        this.value = value;
        this.label = label;
        this.alias = List.of(alias);
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public List<String> getAlias() {
        return alias;
    }
}
