package com.zvyap.hoyoapi.test;

import org.junit.jupiter.api.Assertions;

public class TestUtils {
    public static void notNullAndPrint(Object object) {
//        System.out.println(object); //Manual uncomment this on local development
        Assertions.assertNotNull(object);
    }
}
