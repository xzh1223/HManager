package com.example.xzh.hmanagerclient.general.utils;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2017/10/27.
 */

public class GsonUtil {

    private static Gson getGson() {
        return new Gson();
    }

    /**
     *  将json字符串转化为Bean实体类
     */
    public static Object jsonToBean(String jsonStr, Class<?> c) {
        return getGson().fromJson(jsonStr, c);
    }

    public static String beanToJson(Object obj) {
        return getGson().toJson(obj);
    }

}
