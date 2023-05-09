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
@EnabledIf("com.zvyap.hoyoapi.test.TestConstant#isHonkaiEnabled")
public class HonkaiImpactDailyCheckInTest {
    private HoyoverseAPI osAPI = new HoyoverseAPI(APIEnvironment.OVERSEA);
    private HoyoToken token = HoyoToken.of(TestConstant.HONKAI_TOKEN_ID, TestConstant.HONKAI_TOKEN); //04

    @Test
    public void osHonkaiImpactDailyCheckInGetRewardTest() {
        var feature = new DailyCheckInFeature(osAPI).getAllReward(GameType.HONKAI_IMPACT_3RD);
        Assertions.assertNotNull(feature);

        TestUtils.notNullAndPrint(feature);
    }

    @Test
    public void osHonkaiImpactDailyCheckInGetDailyInfoTest() {
        var feature = new DailyCheckInFeature(osAPI).getDailyInfo(GameType.HONKAI_IMPACT_3RD, token);
        Assertions.assertNotNull(feature);

        TestUtils.notNullAndPrint(feature);
    }

    @Test
    @Disabled
    public void osHonkaiImpactDailyCheckInSignDailyTest() {
        var feature = new DailyCheckInFeature(osAPI).signDaily(GameType.HONKAI_IMPACT_3RD, token);
        Assertions.assertNotNull(feature);

        TestUtils.notNullAndPrint(feature);
    }
}
