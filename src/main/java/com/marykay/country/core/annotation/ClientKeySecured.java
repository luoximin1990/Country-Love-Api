package com.marykay.country.core.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * Created by wanwei on 2016/9/23.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Documented
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface ClientKeySecured {
    int RESTRICT_NONE = 0;
    int RESTRICT_INTERNAL = 1;

    int restrict() default RESTRICT_INTERNAL;
}
