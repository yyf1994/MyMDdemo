package com.yyf.mymedemo.service;

import com.yyf.mymedemo.model.Book;
import com.yyf.mymedemo.model.News;
import com.yyf.mymedemo.model.UserInfo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2016/3/24.
 */
public interface MDService {
    /**
     * https://api.douban.com/v2/book/1220562   暂时没用
     * */

    @GET("/v2/book/1220562")
    Call<Book> loadBook();

    /**
     * http://api.douban.com/labs/bubbler/user/ahbei 暂时没用
     * */
    @GET("/labs/bubbler/user/{user}")
    Call<UserInfo> loadUserInfo(@Path("user") String user);

    /**
     * http://api.douban.com/labs/bubbler/user/ahbei
     * */
    @GET("/onebox/news/query")
    Call<News> loadNews(
            @Query("q") String q,
            @Query("dtype") String dtype,
            @Query("key") String key);


    @FormUrlEncoded
    @POST("/onebox/news/query")
    Call<News> loadNewsPost(
            @Field("q") String q,
            @Field("dtype") String dtype,
            @Field("key") String key);

}
