package com.example.zheng.maptreasure.register;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhengshujuan on 2016/7/14.
 * 网络连接的单利模式
 */
public class NetClient {
    private static NetClient netClient;
    private final OkHttpClient httpClient;
    private final Retrofit retrofit;
    private Gson gson;
    public static final String BASE_URL = "http://admin.syfeicuiedu.com";

    private NetClient() {
        httpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();
    }

    public OkHttpClient getHttpClient() {
        return httpClient;
    }


    public static NetClient getInstance() {
        if (netClient == null) {
            netClient = new NetClient();
        }
        return netClient;
    }

    private UserApi userApi;

    public UserApi getUserApi() {
        if (userApi == null) {
            // retrofit核心代码
            // 将http api转化的java接口进行代码构建(根据注解等)
            userApi = retrofit.create(UserApi.class);
        }
        return userApi;
    }
}
