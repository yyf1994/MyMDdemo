package com.yyf.mymedemo.service;

import com.yyf.mymedemo.model.Book;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2016/3/24.
 */
public interface MDService {
    //https://api.douban.com/v2/book/1220562

    @GET("/v2/book/1220562")
    Call<Book> loadBook();

}
