package com.arpitparekh.hardikbhagvatproject.viewBinding_dataBinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.arpitparekh.hardikbhagvatproject.databinding.ActivityMyBinding;
import com.google.android.material.snackbar.Snackbar;

public class MyActivity extends AppCompatActivity {

    private ActivityMyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // lambda method

        // {  view ->  }


        binding.btnHello.setOnClickListener(view -> {

            Snackbar.make(view,"This is Snack Bar",Snackbar.LENGTH_SHORT).show();

        });

        // dataBinding

        binding.button.setOnClickListener(view -> {

            Emp e = new Emp("patil","patil@gmail.com");

            binding.setObject(e);

        });
    }
}