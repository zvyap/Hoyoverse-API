package com.zvyap.hoyoapi.annotation;

import com.zvyap.hoyoapi.APIEnvironment;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.CONSTRUCTOR, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface OnlyAPI {
    /**
     * API only contain at which environment
     *
     * @return APIEnvironment
     */
    APIEnvironment env();

    /**
     * Is this API only can run in that environment
     *
     * @return Boolean
     */
    boolean isStrict() default false;
}
