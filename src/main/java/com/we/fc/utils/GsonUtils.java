package com.we.fc.utils;

import com.google.gson.Gson;

/**
 * @author zdc
 * @since 2018-04-13 22:27
 */

public class GsonUtils {

    private static Gson gson = new Gson();

    public static<T> T toBean(String json, Class<T> c){
        return gson.fromJson(json, c);
    }

    public static<T> String toJson(T t){
        return gson.toJson(t);
    }
}
