package com.zvyap.hoyoapi.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Case sensitive annotation
 *
 * This annotation note some value or parameter is case sensitive and should be treated more carefully
 * Field or method without this annotation is not 100% not case sensitive,
 * this annotation just note out some field or method is extremely case sensitive
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface CaseSensitive {
}
