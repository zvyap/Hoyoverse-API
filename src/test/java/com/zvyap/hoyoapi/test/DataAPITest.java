package com.zvyap.hoyoapi.test;

import com.zvyap.hoyoapi.APIEnvironment;
import com.zvyap.hoyoapi.GameType;
import com.zvyap.hoyoapi.HoyoverseAPI;
import com.zvyap.hoyoapi.response.MYSNavigatorsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataAPITest {
    private HoyoverseAPI api = new HoyoverseAPI(APIEnvironment.OVERSEA);

    @Test
    public void getGameDetailsTest() {
        Assertions.assertEquals(api.getGameDetails(GameType.GENSHIN_IMPACT).getName(), "Genshin Impact");
        TestUtils.notNullAndPrint(api.getGameDetails());
    }

    @Test
    public void getNavigatorsTest() {
        TestUtils.notNullAndPrint(api.getNavigators(GameType.GENSHIN_IMPACT).getNavigator(MYSNavigatorsResponse.Type.WEB_GTOOL_PC).get(0));
        TestUtils.notNullAndPrint(api.getNavigators(GameType.HONKAI_IMPACT_3RD));
    }
}
