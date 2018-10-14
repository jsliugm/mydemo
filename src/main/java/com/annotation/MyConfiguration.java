package com.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by jsliu on 2018/6/26.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyConfiguration {
    String value() default "";
}
