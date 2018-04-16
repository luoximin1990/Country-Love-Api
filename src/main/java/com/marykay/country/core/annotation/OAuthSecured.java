package com.marykay.country.core.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * Created by wanwei on 2016/9/22.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Documented
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface OAuthSecured {
    String role() default "client";
}
