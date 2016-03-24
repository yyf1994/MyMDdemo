package com.yyf.mymedemo.net.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/3/24.
 */
public class NetWork {

    private static final String _host = "https://api.douban.com";

    public static Retrofit getRetrofit(){
        return new retrofit2.Retrofit.Builder().
                baseUrl(_host)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static class SingleTonInstance {
        private static final NetWork instance = new NetWork();
    }

    public static NetWork getInstance() {
        return SingleTonInstance.instance ;
    }

}
