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
@EnabledIf("com.zvyap.hoyoapi.test.TestConstant#isToTEnabled")
public class TearsOfThemisDailyCheckInTest {

    private HoyoverseAPI osAPI = new HoyoverseAPI(APIEnvironment.OVERSEA);
    private HoyoverseAPI osCHINA = new HoyoverseAPI(APIEnvironment.CHINA, Locale.CHINA);
    private HoyoToken token = HoyoToken.of(TestConstant.TOT_TOKEN_ID, TestConstant.TOT_TOKEN); //ys

    @Test
    public void osTearsOfThemisDailyCheckInGetRewardTest() {
        var feature = new DailyCheckInFeature(osAPI).getAllReward(GameType.TEARS_OF_THEMIS);
        Assertions.assertNotNull(feature);

        TestUtils.notNullAndPrint(feature);
    }

    @Test
    public void osTearsOfThemisDailyCheckInGetDailyInfoTest() {
        var feature = new DailyCheckInFeature(osAPI).getDailyInfo(GameType.TEARS_OF_THEMIS, token);
        Assertions.assertNotNull(feature);

        TestUtils.notNullAndPrint(feature);
    }

    @Test
    @Disabled
    public void osTearsOfThemisDailyCheckInSignDailyTest() {
        var feature = new DailyCheckInFeature(osAPI).signDaily(GameType.TEARS_OF_THEMIS, token);
        Assertions.assertNotNull(feature);

        TestUtils.notNullAndPrint(feature);
    }
}
