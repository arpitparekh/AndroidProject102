package com.arpitparekh.hardikbhagvatproject.widget_component;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;

import com.arpitparekh.hardikbhagvatproject.R;
import com.arpitparekh.hardikbhagvatproject.databinding.ActivityStcactivityBinding;

public class STCActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private ActivityStcactivityBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStcactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.getRoot().setBackgroundColor(Color.YELLOW);

        binding.checkBox.setOnCheckedChangeListener(this);
        binding.switch2.setOnCheckedChangeListener(this);
        binding.toggleButton.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        if(b){

            binding.checkBox.setChecked(true);
            binding.toggleButton.setChecked(true);
            binding.switch2.setChecked(true);

            if(compoundButton==binding.checkBox){

                binding.getRoot().setBackgroundColor(Color.LTGRAY);

            }else if(compoundButton==binding.switch2){

                binding.getRoot().setBackgroundColor(Color.rgb(120,125,12));

            }else if(compoundButton==binding.toggleButton){

                binding.getRoot().setBackgroundResource(R.drawable.image);

            }

        }else{

            binding.getRoot().setBackgroundColor(Color.YELLOW);

            binding.checkBox.setChecked(false);
            binding.toggleButton.setChecked(false);
            binding.switch2.setChecked(false);

        }

    }
}