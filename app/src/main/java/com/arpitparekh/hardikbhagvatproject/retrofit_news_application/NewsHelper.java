package com.arpitparekh.hardikbhagvatproject.retrofit_news_application;

import com.arpitparekh.hardikbhagvatproject.retrofit_news_application.NewsApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsHelper {

    public static NewsApi getApiInstance(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewsApi api = retrofit.create(NewsApi.class);

        return api;
    }

}
