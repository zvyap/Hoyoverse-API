package com.zvyap.hoyoapi.test;

import com.zvyap.hoyoapi.APIEnvironment;
import com.zvyap.hoyoapi.GameType;
import com.zvyap.hoyoapi.HoyoToken;
import com.zvyap.hoyoapi.HoyoverseAPI;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class APITest {
    private HoyoToken token = HoyoToken.of(TestConstant.GENSHIN_TOKEN_ID, TestConstant.GENSHIN_TOKEN);
    private HoyoverseAPI api = new HoyoverseAPI(APIEnvironment.OVERSEA);

    @Test
    public void getGameRolesTest() {
        TestUtils.notNullAndPrint(api.getGameRoles(token, GameType.GENSHIN_IMPACT));
        TestUtils.notNullAndPrint(api.getGameRoles(token, GameType.HONKAI_IMPACT_3RD));
        TestUtils.notNullAndPrint(api.getGameRoles(token, GameType.HONKAI_STAR_RAIL));
        TestUtils.notNullAndPrint(api.getGameRoles(token, GameType.TEARS_OF_THEMIS));
        TestUtils.notNullAndPrint(api.getGameRoles(token, GameType.ZENLESS_ZONE_ZERO));
    }

    @Test
    public void getForumUserInfoTest() {
        TestUtils.notNullAndPrint(api.getForumUser(TestConstant.GENSHIN_TOKEN_ID));
    }

    @Test
    public void getAccountUserInfoTest() {
        TestUtils.notNullAndPrint(api.getAccountInfo(token));
    }
}
