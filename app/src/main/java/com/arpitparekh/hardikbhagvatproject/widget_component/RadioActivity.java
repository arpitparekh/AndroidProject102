package com.arpitparekh.hardikbhagvatproject.widget_component;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.arpitparekh.hardikbhagvatproject.databinding.ActivityRadioBinding;

public class RadioActivity extends AppCompatActivity {

    private ActivityRadioBinding binding;
    private String choice=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRadioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rgSubject.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                RadioButton rb = findViewById(radioGroup.getCheckedRadioButtonId());

                choice = rb.getText().toString();

                Toast.makeText(RadioActivity.this, choice, Toast.LENGTH_SHORT).show();

            }
        });

    }
}