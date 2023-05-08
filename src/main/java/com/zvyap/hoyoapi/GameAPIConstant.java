package com.zvyap.hoyoapi;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

@Builder(access = AccessLevel.PACKAGE)
@NotNull
@Value
public class GameAPIConstant {

    private GameType gameType;
    private String apiUrl;

    private String dailyCheckInApiEndpoint;
    private String dailyCheckInActId;
    private String gameBiz;

}
