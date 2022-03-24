package com.arpitparekh.hardikbhagvatproject.widget_component;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;

import com.arpitparekh.hardikbhagvatproject.databinding.ActivitySeekBarBinding;

public class SeekBarActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private ActivitySeekBarBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySeekBarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ivColorCode.setBackgroundColor(Color.BLACK);

        binding.sbBlue.setOnSeekBarChangeListener(this);
        binding.sbGreen.setOnSeekBarChangeListener(this);
        binding.sbRed.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        int red = binding.sbRed.getProgress();
        int green = binding.sbBlue.getProgress();
        int blue = binding.sbGreen.getProgress();

        binding.ivColorCode.setBackgroundColor(Color.rgb(red,green,blue));

        binding.textView2.setText(String.format("#%02x%02x%02x", red, green,blue));

        binding.textView3.setText(red+" "+green+" "+blue);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}