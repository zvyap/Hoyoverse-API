package com.zvyap.hoyoapi;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

@Builder(access = AccessLevel.PACKAGE)
@NotNull
@Value
public class AccountAPIConstant {
    String userGameRoleEndpoint;
    String userAccountInfoEndpoint;

    String forumFullUserInfoEndpoint;
}
