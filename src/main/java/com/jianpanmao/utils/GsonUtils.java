package com.jianpanmao.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author zdc
 * @since 2018-04-13 22:27
 */

public class GsonUtils {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public static<T> T toBean(String json, Class<T> c){
        return gson.fromJson(json, c);
    }

    public static<T> String toJson(T t){
        return gson.toJson(t);
    }

    class Test{
        private String str;

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }
    }

}
