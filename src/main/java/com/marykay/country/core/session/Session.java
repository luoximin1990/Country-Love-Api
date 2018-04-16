package com.marykay.country.core.session;

import java.util.HashMap;

/**
 * Created by wanwei on 2016/9/22.
 */
public class Session {
    private HashMap<String, Object> storage = new HashMap<>();

    public Object get(String key) {
        return storage.get(key);
    }

    public void set(String key, Object value) {
        
    }
}
