package com.arpitparekh.hardikbhagvatproject.json_parsing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.arpitparekh.hardikbhagvatproject.databinding.ActivityOnlineJsonBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OnlineJsonActivity extends AppCompatActivity {

    private ActivityOnlineJsonBinding binding;
    private ArrayList<Note> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnlineJsonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        // https://jsonplaceholder.typicode.com/posts

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts")
                .build();

        Call call =  client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                try {
                    String json = response.body().string();

                    JSONArray jsonArray = new JSONArray(json);

                    for(int i=0;i<jsonArray.length();i++){

                        JSONObject object = jsonArray.getJSONObject(i);

                        String title =  object.getString("title");
                        String body = object.getString("body");

                        Note note = new Note(title,body);

                        list.add(note);

                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            ArrayAdapter<Note> adapter = new ArrayAdapter<>(OnlineJsonActivity.this, android.R.layout.simple_list_item_1,list);
                            binding.listViewJson.setAdapter(adapter);

                        }
                    });
                } catch (JSONException e) {
                    Log.i("responseError",e.toString());
                }


            }
        });

    }
}