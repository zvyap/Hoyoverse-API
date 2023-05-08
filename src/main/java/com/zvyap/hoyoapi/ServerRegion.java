package com.zvyap.hoyoapi;

import com.zvyap.hoyoapi.util.Utils;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Map;

//Unimplemented yet
//https://api-account-os.hoyolab.com/account/binding/api/getAllRegions?game_biz=bh3_global
//https://api-takumi.mihoyo.com/account/binding/api/getAllRegions?game_biz=hkrpg_cn
public enum ServerRegion {
    ASIA(Map.of(
            GameType.GENSHIN_IMPACT, "os_asia",
            GameType.HONKAI_IMPACT_3RD, "overseas01",
            GameType.HONKAI_STAR_RAIL, "prod_official_asia",
            GameType.TEARS_OF_THEMIS, "glb_prod_wd01")),
    EUROPE(Map.of(
            GameType.GENSHIN_IMPACT, "os_eur",
            GameType.HONKAI_IMPACT_3RD, "eur01",
            GameType.HONKAI_STAR_RAIL, "prod_official_eur",
            GameType.TEARS_OF_THEMIS, "glb_prod_wd01")),
    AMERICA(Map.of(
            GameType.GENSHIN_IMPACT, "os_usa",
            GameType.HONKAI_IMPACT_3RD, "usa01",
            GameType.HONKAI_STAR_RAIL, "prod_official_usa",
            GameType.TEARS_OF_THEMIS, "glb_prod_wd01")),
    TW_HK_MO(Map.of(
            GameType.GENSHIN_IMPACT, "os_cht",
            GameType.HONKAI_IMPACT_3RD, "asia01",
            GameType.HONKAI_STAR_RAIL, "prod_official_cht",
            GameType.TEARS_OF_THEMIS, "glb_prod_wd01")),
    KOREA(Map.of(
            GameType.GENSHIN_IMPACT, Utils.UNKNOWN,
            GameType.HONKAI_IMPACT_3RD, "kr01",
            GameType.HONKAI_STAR_RAIL, Utils.UNKNOWN,
            GameType.TEARS_OF_THEMIS, Utils.UNKNOWN)),
    JAPAN(Map.of(
            GameType.GENSHIN_IMPACT, Utils.UNKNOWN,
            GameType.HONKAI_IMPACT_3RD, "jp01",
            GameType.HONKAI_STAR_RAIL, Utils.UNKNOWN,
            GameType.TEARS_OF_THEMIS, Utils.UNKNOWN)),
    CHINA_OFFICIAL(Map.of(
            GameType.GENSHIN_IMPACT, "cn_gf01", //SKY_ISLAND
            GameType.HONKAI_IMPACT_3RD, "ios01,android01,pc01",
            GameType.HONKAI_STAR_RAIL, "prod_gf_cn", //pre_090_cn,pre_100_cn - what is these server
            GameType.TEARS_OF_THEMIS, "cn_prod_gf01")),
    CHINA_MIX(Map.of(
            GameType.GENSHIN_IMPACT, "cn_qd01", //SKY_TREE
            GameType.HONKAI_IMPACT_3RD, "hun01,hun02,yyb01",
            GameType.HONKAI_STAR_RAIL, "prod_qd_cn",
            GameType.TEARS_OF_THEMIS, "cn_prod_mix01")),
    BILIBILI(Map.of(
            GameType.GENSHIN_IMPACT, "null",
            GameType.HONKAI_IMPACT_3RD, "bb01",
            GameType.HONKAI_STAR_RAIL, Utils.UNKNOWN,
            GameType.TEARS_OF_THEMIS, "cn_prod_bb01"));

    private Map<GameType, String> region;

    ServerRegion(Map<GameType, String> region) {
        this.region = region;
    }

    public Map<GameType, String> getRegionString() {
        return region;
    }

    public String getRegion(GameType gameType) {
        return getRegionString().get(gameType);
    }

    public boolean match(String region) {
        for(String r : getRegionString().values()) {
            if(match(r, region)) {
                return true;
            }
        }
        return false;
    }

    private static boolean match(String currentRegion, String region) {
        if(currentRegion == null) {
            return false;
        }
        if(currentRegion.contains(",")) {
            String[] split = currentRegion.split(",");
            return ArrayUtils.contains(split, region);
        }
        if(currentRegion.equals(region)) {
            return true;
        }
        return false;
    }

    public boolean match(GameType gameType, String region) {
        return match(getRegion(gameType), region);
    }
}