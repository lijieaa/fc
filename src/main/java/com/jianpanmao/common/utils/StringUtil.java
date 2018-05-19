package com.jianpanmao.common.utils;


public class StringUtil {

    public static  String orderByStringProcess(String orderByString){
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i <orderByString.length() ; i++) {
            char c = orderByString.charAt(i);
            if(Character.isUpperCase(c)){
                sb.append("_");
                sb.append(Character.toLowerCase(c));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static  String beanPropertyProcess(String property){
        StringBuilder sb = new StringBuilder();

        sb.append(property);
        if (Character.isLowerCase(sb.charAt(0))) {
            if (sb.length() == 1 || !Character.isUpperCase(sb.charAt(1))) {
                sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            }
        }

        return sb.toString();
    }
}
