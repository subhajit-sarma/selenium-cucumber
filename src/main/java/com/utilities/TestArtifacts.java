package com.utilities;

import java.util.HashMap;
import java.util.Map;

public class TestArtifacts {
    private static Map<String, Object> data = new HashMap<>();

    public static Object get(String key){
        return data.get(key);
    }

    public static void set(String key, Object value){
        data.put(key, value);
    }
    
}
