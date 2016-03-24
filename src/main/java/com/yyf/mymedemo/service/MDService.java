package com.yyf.mymedemo.service;

import com.yyf.mymedemo.model.Book;
import com.yyf.mymedemo.model.UserInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2016/3/24.
 */
public interface MDService {
    /**
     * https://api.douban.com/v2/book/1220562
     * */

    @GET("/v2/book/1220562")
    Call<Book> loadBook();

    /**
     * http://api.douban.com/labs/bubbler/user/ahbei
     * */
    @GET("/labs/bubbler/user/{user}")
    Call<UserInfo> loadUserInfo(@Path("user") String user);

}
