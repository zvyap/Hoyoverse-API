package com.zvyap.hoyoapi.test.feature;

import com.zvyap.hoyoapi.APIEnvironment;
import com.zvyap.hoyoapi.GameType;
import com.zvyap.hoyoapi.HoyoToken;
import com.zvyap.hoyoapi.HoyoverseAPI;
import com.zvyap.hoyoapi.feature.daily.DailyCheckInFeature;
import com.zvyap.hoyoapi.test.TestConstant;
import com.zvyap.hoyoapi.test.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledIf;

import java.util.Locale;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@EnabledIf("com.zvyap.hoyoapi.test.TestConstant#isGenshinEnabled")
public class GenshinDailyCheckInTest {

    private HoyoverseAPI osAPI = new HoyoverseAPI(APIEnvironment.OVERSEA);
    private HoyoverseAPI osCHINA = new HoyoverseAPI(APIEnvironment.CHINA, Locale.CHINA);
    private HoyoToken token = HoyoToken.of(TestConstant.GENSHIN_TOKEN_ID, TestConstant.GENSHIN_TOKEN);

    @Test
    public void osGenshinDailyCheckInGetRewardTest() {
        var feature = new DailyCheckInFeature(osAPI).getAllReward(GameType.GENSHIN_IMPACT);
        Assertions.assertNotNull(feature);

        TestUtils.notNullAndPrint(feature);
    }

    @Test
    public void osGenshinDailyCheckInGetDailyInfoTest() {
        var feature = new DailyCheckInFeature(osAPI).getDailyInfo(GameType.GENSHIN_IMPACT, token);
        Assertions.assertNotNull(feature);

        TestUtils.notNullAndPrint(feature);
    }

    @Test
    @Disabled
    public void osGenshinDailyCheckInSignDailyTest() {
        var feature = new DailyCheckInFeature(osAPI).signDaily(GameType.GENSHIN_IMPACT, token);
        Assertions.assertNotNull(feature);

        TestUtils.notNullAndPrint(feature);
    }
}
