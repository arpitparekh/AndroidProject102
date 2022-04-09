package com.arpitparekh.hardikbhagvatproject.viewPager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.arpitparekh.hardikbhagvatproject.databinding.ActivityMyPagerBinding;
import com.google.android.material.tabs.TabLayout;

public class MyPagerActivity extends AppCompatActivity {

    private ActivityMyPagerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyPagerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Chat"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Status"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Calls"));

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(),getLifecycle());

        binding.viewPager.setAdapter(adapter);

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });


    }
}