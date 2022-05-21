package com.arpitparekh.hardikbhagvatproject.retrofit_news_application;

import com.arpitparekh.hardikbhagvatproject.retrofit_news_application.classes.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    @GET("v2/everything")
    Call<News> getNews(@Query("q")String data, @Query("apikey")String key);


}
