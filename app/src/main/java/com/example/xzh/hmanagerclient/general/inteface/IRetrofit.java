package com.example.xzh.hmanagerclient.general.inteface;

import com.example.xzh.hmanagerclient.general.bean.User;
import com.example.xzh.hmanagerclient.user.work.bean.Work;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017/10/28.
 */

public interface IRetrofit {

    @POST("login")
    Call<User> login(@Body RequestBody body);

    @GET("findWorksByUserId/{userId}")
    Call<List<Work>> findWorksByUserId(@Path("userId") int userId);

    @POST("addWork")
    Call<Integer> addWork(@Body RequestBody body);

}
