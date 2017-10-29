package com.example.xzh.hmanagerclient.general.controller;

import com.example.xzh.hmanagerclient.general.bean.User;
import com.example.xzh.hmanagerclient.general.inteface.IRetrofit;
import com.example.xzh.hmanagerclient.general.utils.GsonUtil;
import com.example.xzh.hmanagerclient.user.work.bean.Work;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/10/28.
 */

public class DBController {

    static Retrofit hmanager = new Retrofit.Builder()
            .baseUrl("http://192.168.100.22:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    static IRetrofit iRetrofit = hmanager.create(IRetrofit.class);

    /**
     *  登录
     */
    public static void login(User user, Callback<User> callback) {
        String json = GsonUtil.beanToJson(user);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);
        Call<User> call = iRetrofit.login(body);
        call.enqueue(callback);
    }

    /**
     *  根据id查找work数据列表
     */
    public static void findWorksByUserId(int userId, Callback<List<Work>> callback) {
        Call<List<Work>> call = iRetrofit.findWorksByUserId(userId);
        call.enqueue(callback);
    }

    /**
     *  Work 添加
     */
    public static void addWork(Work work, Callback callback) {
        String json = GsonUtil.beanToJson(work);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);
        Call call  = iRetrofit.addWork(body);
        call.enqueue(callback);
    }

}
