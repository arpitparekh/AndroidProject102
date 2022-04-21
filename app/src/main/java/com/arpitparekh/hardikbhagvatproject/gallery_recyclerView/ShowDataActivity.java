package com.arpitparekh.hardikbhagvatproject.gallery_recyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.arpitparekh.hardikbhagvatproject.databinding.ActivityShowDataBinding;

import java.util.ArrayList;

public class ShowDataActivity extends AppCompatActivity {

    private ActivityShowDataBinding binding;
    private ArrayList<Gallery> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recyclerViewShowImage.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        list = new ArrayList<>();

        Intent i = getIntent();

        Bundle b = i.getBundleExtra("bundle");

        ArrayList<Gallery> newList = (ArrayList<Gallery>) b.getSerializable("list");

        int position = i.getIntExtra("position",0);

        list = newList;

        GalleryAdapter adapter = new GalleryAdapter(list);

        binding.recyclerViewShowImage.setAdapter(adapter);

        binding.recyclerViewShowImage.smoothScrollToPosition(position);


    }
}