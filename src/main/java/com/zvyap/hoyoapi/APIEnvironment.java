package com.zvyap.hoyoapi;

import com.zvyap.hoyoapi.exception.HoyoverseAPIMissingException;
import org.jetbrains.annotations.Nullable;

public enum APIEnvironment {
    OVERSEA(AccountAPIConstant.builder()
                    .userGameRoleEndpoint("https://api-account-os.hoyoverse.com/binding/api/getUserGameRolesByLtoken")
                    .userAccountInfoEndpoint("https://api-account-os.hoyolab.com/auth/api/getUserAccountInfoByLToken")
                    .forumFullUserInfoEndpoint("https://bbs-api-os.hoyolab.com/community/user/wapi/getUserFullInfo")
                    .build(),
            GameAPIConstant.builder()
                    .gameType(GameType.GENSHIN_IMPACT)
                    .apiUrl("https://hk4e-api-os.hoyoverse.com")
                    .dailyCheckInApiEndpoint("https://hk4e-api-os.hoyoverse.com/event/sol")
                    .dailyCheckInActId("e202102251931481")
                    .gameBiz("hk4e_global")
                    .build(),
            GameAPIConstant.builder()
                    .gameType(GameType.HONKAI_IMPACT_3RD)
                    .apiUrl("https://sg-public-api.hoyolab.com")
                    .dailyCheckInApiEndpoint("https://sg-public-api.hoyolab.com/event/mani")
                    .dailyCheckInActId("e202110291205111")
                    .gameBiz("bh3_global")
                    .build(),
            GameAPIConstant.builder()
                    .gameType(GameType.HONKAI_STAR_RAIL)
                    .apiUrl("https://sg-public-api.hoyolab.com")
                    .dailyCheckInApiEndpoint("https://sg-public-api.hoyolab.com/event/luna/os")
                    .dailyCheckInActId("e202303301540311")
                    .gameBiz("hkrpg_global")
                    .build(),
            GameAPIConstant.builder()
                    .gameType(GameType.TEARS_OF_THEMIS)
                    .apiUrl("https://sg-public-api.hoyolab.com")
                    .dailyCheckInApiEndpoint("https://sg-public-api.hoyolab.com/event/luna/os")
                    .dailyCheckInActId("e202202281857121")
                    .gameBiz("nxx_global")
                    .build()),

    CHINA(AccountAPIConstant.builder()
                    .userGameRoleEndpoint("https://api-takumi.mihoyo.com/binding/api/getUserGameRolesByLtoken")
                    .userGameRoleEndpoint("https://api-takumi.mihoyo.com/auth/api/getUserAccountInfoByLToken")
                    .forumFullUserInfoEndpoint("https://bbs-api.miyoushe.com/user/wapi/getUserFullInfo")
                    .build(),
            GameAPIConstant.builder()
                    .gameType(GameType.GENSHIN_IMPACT)
                    .apiUrl("https://api-takumi.mihoyo.com")
                    .dailyCheckInApiEndpoint("https://api-takumi.mihoyo.com/event/bbs_sign_reward/")
                    .dailyCheckInActId("e202009291139501")
                    .gameBiz("hk4e_cn")
                    .build(),
            GameAPIConstant.builder()
                    .gameType(GameType.HONKAI_IMPACT_3RD)
                    .apiUrl("")
                    .dailyCheckInApiEndpoint("")
                    .dailyCheckInActId("")
                    .gameBiz("bh3_cn")
                    .build(),
            GameAPIConstant.builder()
                    .gameType(GameType.HONKAI_STAR_RAIL)
                    .apiUrl("")
                    .dailyCheckInApiEndpoint("")
                    .dailyCheckInActId("")
                    .gameBiz("hkrpg_cn")
                    .build(),
            GameAPIConstant.builder()
                    .gameType(GameType.TEARS_OF_THEMIS)
                    .apiUrl("")
                    .dailyCheckInApiEndpoint("")
                    .dailyCheckInActId("")
                    .gameBiz("nxx_cn")
                    .build());

    private final AccountAPIConstant accountAPIConstant;
    public final GameAPIConstant GENSHIN;
    public final GameAPIConstant HONKAI_IMPACT_3RD;
    public final GameAPIConstant HONKAI_STAR_RAIL;
    public final GameAPIConstant TEARS_OF_THEMIS;

    APIEnvironment(AccountAPIConstant accountAPIConstant, GameAPIConstant GENSHIN, GameAPIConstant HONKAI_IMPACT_3RD, GameAPIConstant HONKAI_STAR_RAIL, GameAPIConstant TEARS_OF_THEMIS) {
        this.accountAPIConstant = accountAPIConstant;
        this.GENSHIN = GENSHIN;
        this.HONKAI_IMPACT_3RD = HONKAI_IMPACT_3RD;
        this.HONKAI_STAR_RAIL = HONKAI_STAR_RAIL;
        this.TEARS_OF_THEMIS = TEARS_OF_THEMIS;
    }

    public AccountAPIConstant getAccountAPIConstant() {
        return accountAPIConstant;
    }

    public GameAPIConstant[] getAllAPIConstant() {
        return new GameAPIConstant[] {GENSHIN, HONKAI_IMPACT_3RD, HONKAI_STAR_RAIL, TEARS_OF_THEMIS};
    }

    public GameAPIConstant getAPIConstant(GameType gameType) {
        switch (gameType) {
            case GENSHIN_IMPACT:
                return GENSHIN;
            case HONKAI_IMPACT_3RD:
                return HONKAI_IMPACT_3RD;
            case HONKAI_STAR_RAIL:
                return HONKAI_STAR_RAIL;
            case TEARS_OF_THEMIS:
                return TEARS_OF_THEMIS;
            default:
                throw new HoyoverseAPIMissingException("GameAPIConstant");
        }
    }

    @Nullable
    public static GameAPIConstant getAPIConstantByGameBiz(String gameBiz) {
        for(APIEnvironment environment : values()) {
            for(GameAPIConstant c : environment.getAllAPIConstant()) {
                if(c.getGameBiz().equals(gameBiz)) {
                    return c;
                }
            }
        }
        throw new HoyoverseAPIMissingException("gameBiz["+gameBiz+"]");
    }
}
