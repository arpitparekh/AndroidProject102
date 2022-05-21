package com.arpitparekh.hardikbhagvatproject.retrofit_news_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.arpitparekh.hardikbhagvatproject.databinding.ActivityNewsListBinding;
import com.arpitparekh.hardikbhagvatproject.retrofit_news_application.classes.News;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsListActivity extends AppCompatActivity {

    private ActivityNewsListBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewsListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Call<News> call =  NewsHelper.getApiInstance().getNews("Narendra Modi","494cacf0370b4038bfc22fb8be7c2595");

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                News news =  response.body();

                Log.i("response",news.toString());
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });



    }
}