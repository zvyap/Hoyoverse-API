package com.zvyap.hoyoapi.test;

public class TestConstant {

    public static final boolean GLOBAL_TEST = true;

    public static final boolean GENSHIN_TEST = true;
    public static final boolean HONKAI_TEST = true;
    public static final boolean HSR_TEST = true;
    public static final boolean TOT_TEST = true;
    public static final boolean ZZZ_TEST = true;

    public static final String GLOBAL_TOKEN = System.getenv("GLOBAL_TOKEN");
    public static final String GLOBAL_TOKEN_ID = System.getenv("GLOBAL_TOKEN_ID");
    public static final String GENSHIN_TOKEN = System.getenv("GENSHIN_TOKEN") == null ? GLOBAL_TOKEN : System.getenv("GENSHIN_TOKEN");
    public static final String GENSHIN_TOKEN_ID = System.getenv("GENSHIN_TOKEN_ID") == null ? GLOBAL_TOKEN_ID : System.getenv("GENSHIN_TOKEN_ID");
    public static final String HONKAI_TOKEN = System.getenv("HONKAI_TOKEN") == null ? GLOBAL_TOKEN : System.getenv("HONKAI_TOKEN");
    public static final String HONKAI_TOKEN_ID = System.getenv("HONKAI_TOKEN_ID") == null ? GLOBAL_TOKEN_ID : System.getenv("HONKAI_TOKEN_ID");
    public static final String HSR_TOKEN = System.getenv("HSR_TOKEN") == null ? GLOBAL_TOKEN : System.getenv("HSR_TOKEN");
    public static final String HSR_TOKEN_ID = System.getenv("HSR_TOKEN_ID") == null ? GLOBAL_TOKEN_ID : System.getenv("HSR_TOKEN_ID");
    public static final String TOT_TOKEN = System.getenv("TOT_TOKEN") == null ? GLOBAL_TOKEN : System.getenv("TOT_TOKEN");
    public static final String TOT_TOKEN_ID = System.getenv("TOT_TOKEN_ID") == null ? GLOBAL_TOKEN_ID : System.getenv("TOT_TOKEN_ID");
    public static final String ZZZ_TOKEN = System.getenv("ZZZ_TOKEN") == null ? GLOBAL_TOKEN : System.getenv("ZZZ_TOKEN");
    public static final String ZZZ_TOKEN_ID = System.getenv("ZZZ_TOKEN_ID") == null ? GLOBAL_TOKEN_ID : System.getenv("ZZZ_TOKEN_ID");

    public static boolean isGenshinEnabled() {
        return GENSHIN_TEST && GENSHIN_TOKEN != null && GENSHIN_TOKEN_ID != null;
    }

    public static boolean isHonkaiEnabled() {
        return HONKAI_TEST && HONKAI_TOKEN != null && HONKAI_TOKEN_ID != null;
    }

    public static boolean isStarRailEnabled() {
        return HSR_TEST && HSR_TOKEN != null && HSR_TOKEN_ID != null;
    }

    public static boolean isToTEnabled() {
        return TOT_TEST && TOT_TOKEN != null && TOT_TOKEN_ID != null;
    }

    public static boolean isZZZEnabled() {
        return ZZZ_TEST && ZZZ_TOKEN != null && ZZZ_TOKEN_ID != null;
    }

    public static boolean isMainTestEnabled() {
        return GLOBAL_TEST && GLOBAL_TOKEN != null && GLOBAL_TOKEN_ID != null;
    }
}
