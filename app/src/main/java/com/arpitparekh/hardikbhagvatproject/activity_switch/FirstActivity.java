package com.arpitparekh.hardikbhagvatproject.activity_switch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.arpitparekh.hardikbhagvatproject.R;  // import resources in activity
import com.google.android.material.snackbar.Snackbar;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        // View

        Button b1 = findViewById(R.id.btnToast);
        Button b2 = findViewById(R.id.btnSnackBar);
        Button b3 = findViewById(R.id.btnSwitch);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Toast

                Toast.makeText(FirstActivity.this,"This is Toast",Toast.LENGTH_LONG).show();

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view,"This is snakeBar",Snackbar.LENGTH_SHORT).show();

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Intent

                Intent i = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(i);

            }
        });

    }
}