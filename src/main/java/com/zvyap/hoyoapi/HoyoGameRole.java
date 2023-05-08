package com.zvyap.hoyoapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HoyoGameRole {
    GameType gameType;

    @JsonProperty("is_chosen")
    private boolean isChosen;

    @JsonProperty("game_uid")
    private String gameUid;

    @JsonProperty("is_official")
    private boolean isOfficial;

    @JsonProperty("level")
    private int level;

    private String gameBiz;

    @JsonProperty("nickname")
    private String nickname;

    @JsonProperty("region_name")
    private String regionName;

    @JsonProperty("region")
    private String region;

    public HoyoGameRole(@JsonProperty("game_biz") String gameBiz) {
        this.gameBiz = gameBiz;
        this.gameType = APIEnvironment.getAPIConstantByGameBiz(gameBiz).getGameType();
    }

    public boolean isIsChosen(){
        return isChosen;
    }

    public String getGameUid(){
        return gameUid;
    }

    public boolean isIsOfficial(){
        return isOfficial;
    }

    public int getLevel(){
        return level;
    }

    public String getGameBiz(){
        return gameBiz;
    }

    public String getNickname(){
        return nickname;
    }

    public String getRegionName(){
        return regionName;
    }

    public String getRegion(){
        return region;
    }

    @Override
    public String toString(){
        return
                "ListItem{" +
                        "is_chosen = '" + isChosen + '\'' +
                        ",game_uid = '" + gameUid + '\'' +
                        ",is_official = '" + isOfficial + '\'' +
                        ",level = '" + level + '\'' +
                        ",game_biz = '" + gameBiz + '\'' +
                        ",nickname = '" + nickname + '\'' +
                        ",region_name = '" + regionName + '\'' +
                        ",region = '" + region + '\'' +
                        "}";
    }
}
