package com.arpitparekh.hardikbhagvatproject.cordinator_layput;

import androidx.appcompat.app.AppCompatActivity;
import com.arpitparekh.hardikbhagvatproject.R;
import android.os.Bundle;

import com.arpitparekh.hardikbhagvatproject.databinding.ActivityMyCoBinding;
import com.google.android.material.snackbar.Snackbar;

public class MyCoActivity extends AppCompatActivity {

    private ActivityMyCoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyCoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fab1.setOnClickListener(view -> {

            Snackbar.make(binding.fab1,getString(R.string.name),Snackbar.LENGTH_SHORT).show();

        });


    }
}