package com.marykay.country.core.support;

import org.springframework.stereotype.Component;

/**
 * Created by wanwei on 2016/11/6.
 */
@Component
public class DefaultEnvironment implements Environment {
    @Override
    public String getVariable(String name) {
        return System.getenv(name);
    }
}
