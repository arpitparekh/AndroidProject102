package com.arpitparekh.hardikbhagvatproject.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.arpitparekh.hardikbhagvatproject.databinding.ActivityHolderBinding;

public class HolderActivity extends AppCompatActivity {

    private ActivityHolderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHolderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}