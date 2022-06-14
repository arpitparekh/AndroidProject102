package com.arpitparekh.hardikbhagvatproject.retrofit_news_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.arpitparekh.hardikbhagvatproject.databinding.ActivityNewsListBinding;
import com.arpitparekh.hardikbhagvatproject.retrofit_news_application.classes.ArticlesItem;
import com.arpitparekh.hardikbhagvatproject.retrofit_news_application.classes.News;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsListActivity extends AppCompatActivity {

    private ActivityNewsListBinding binding;
    private List<ArticlesItem> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewsListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        Call<News> call =  NewsHelper.getApiInstance().getNews("Narendra Modi","494cacf0370b4038bfc22fb8be7c2595");

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                News news =  response.body();

                list =  news.getArticles();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        ArrayAdapter<ArticlesItem> adapter = new ArrayAdapter<>(NewsListActivity.this, android.R.layout.simple_list_item_1,list);

                        binding.listViewNews.setAdapter(adapter);

                    }
                });

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });



    }
}