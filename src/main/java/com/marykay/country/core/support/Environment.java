package com.marykay.country.core.support;

import org.springframework.stereotype.Component;

/**
 * Created by wanwei on 2016/11/5.
 */
public interface Environment {
    String getVariable(String name);
}
