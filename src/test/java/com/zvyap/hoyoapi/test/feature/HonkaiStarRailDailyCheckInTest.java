package com.zvyap.hoyoapi.test.feature;

import com.zvyap.hoyoapi.APIEnvironment;
import com.zvyap.hoyoapi.GameType;
import com.zvyap.hoyoapi.HoyoToken;
import com.zvyap.hoyoapi.HoyoverseAPI;
import com.zvyap.hoyoapi.feature.daily.DailyCheckInFeature;
import com.zvyap.hoyoapi.test.TestConstant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledIf;

import java.util.Locale;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@EnabledIf("com.zvyap.hoyoapi.test.TestConstant#isStarRailEnabled")
public class HonkaiStarRailDailyCheckInTest {

    private HoyoverseAPI osAPI = new HoyoverseAPI(APIEnvironment.OVERSEA);
    private HoyoverseAPI osCHINA = new HoyoverseAPI(APIEnvironment.CHINA, Locale.CHINA);
    private HoyoToken token = HoyoToken.of(TestConstant.HSR_TOKEN_ID, TestConstant.HSR_TOKEN);

    @Test
    public void osHSRDailyCheckInGetRewardTest() {
        var feature = new DailyCheckInFeature(osAPI).getAllReward(GameType.HONKAI_STAR_RAIL);
        Assertions.assertNotNull(feature);

        System.out.println(feature.toString());
    }

    @Test
    public void osHSRDailyCheckInGetDailyInfoTest() {
        var feature = new DailyCheckInFeature(osAPI).getDailyInfo(GameType.HONKAI_STAR_RAIL, token);
        Assertions.assertNotNull(feature);

        System.out.println(feature.toString());
    }

    @Test
    public void osHSRDailyCheckInSignDailyTest() {
        var feature = new DailyCheckInFeature(osAPI).signDaily(GameType.HONKAI_STAR_RAIL, token);
        Assertions.assertNotNull(feature);

        System.out.println(feature.toString());
    }
}
