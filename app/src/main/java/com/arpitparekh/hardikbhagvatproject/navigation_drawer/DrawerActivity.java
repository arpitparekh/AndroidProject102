package com.arpitparekh.hardikbhagvatproject.navigation_drawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.arpitparekh.hardikbhagvatproject.R;
import com.arpitparekh.hardikbhagvatproject.databinding.ActivityDrawerBinding;
import com.google.android.material.navigation.NavigationView;

public class DrawerActivity extends AppCompatActivity {

    private ActivityDrawerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDrawerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.toolbar.setNavigationOnClickListener(view -> {

            binding.drawerLayout.openDrawer(Gravity.LEFT);

        });

        binding.toolbar.setOnMenuItemClickListener(item -> {

            // TODO : menu click

            return false;
        });


        binding.navigationView.setNavigationItemSelectedListener(item -> {

            // TODO : navigation menu click

            return false;
        });

       View view = binding.navigationView.getHeaderView(0);

        ImageView iv = view.findViewById(R.id.ivProfile);
        TextView tv1 = view.findViewById(R.id.tvName);
        TextView tv2 = view.findViewById(R.id.tvEmail);

        // TODO : Do click event



    }
}