package com.zvyap.hoyoapi.test;

import com.zvyap.hoyoapi.*;
import com.zvyap.hoyoapi.response.HoyoGetForumFullUserResponse;

//Example java on how to use HoyoverseAPI wiki
public class HoyoAPIExample {
    private static final HoyoverseAPI api = new HoyoverseAPI(APIEnvironment.OVERSEA);
    //private static final HoyoverseAPI api = new HoyoverseAPI(APIEnvironment.OVERSEA, APILocale.ZH_CN); //Custom language

    public static void main(String[] args) {
        HoyoToken token = HoyoToken.of("your_ltuid", "your_ltoken"); //HoyoToken#of which support V1 & V2 token, RECOMMANDED

        HoyoverseAPI.buildGlobalInstance(APIEnvironment.OVERSEA, APILocale.JP); //Build global instance with custom language
        HoyoverseAPI.getGlobalInstance(); //Get global instance

        HoyoGetForumFullUserResponse response = api.getForumUser(token); //Get self forum user data
        //3 method below included in all response
        response.isSuccess(); //All response included this method to check whether the request is executed by Hoyoverse successfully
        response.getRetcode(); //All response included this method which return 'ERROR CODE' defined by Hoyoverse official API, positive mean healthy, negative number mean unhealthy
        response.getMessage(); //All response included this method which return message from Hoyoverse official API

        String accountId = "99999999"; //Forum user account id is same as TOKEN ID which you can get from URL when you visiting others profile page
        //https://www.hoyolab.com/accountCenter/postList?id=99999999 <- 99999999 is the account id
        System.out.println(api.getForumUser(accountId)); //Get others forum user data

        //Get basic account info with sensitive data being blurred
        System.out.println(api.getAccountInfo(token));

        //Get basic ingame data, such as: nickname, level, in game uid
        //Self game roles only
        System.out.println(api.getGameRoles(token, GameType.GENSHIN_IMPACT));
        System.out.println(api.getGameRoles(token, GameType.GENSHIN_IMPACT, ServerRegion.ASIA));
        System.out.println(api.getGameRoles(token, GameType.GENSHIN_IMPACT, ServerRegion.BILIBILI)); //Some region for China Mainland's server
        System.out.println(api.getGameRoles(token, GameType.GENSHIN_IMPACT, "InGameUID"));

        //Get forum user profile data
        System.out.println(api.getForumUser(token));
        System.out.println(api.getForumUser("otherUserAccountId"));
    }
}