package com.arpitparekh.hardikbhagvatproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {


    // activity lifecycle

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("life","create");

        Button b =  findViewById(R.id.btnGoNext);
        Button b2 = findViewById(R.id.btnGoNext2);
        FloatingActionButton fab = findViewById(R.id.fb);
        ImageView iv = findViewById(R.id.imageView);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"This is Image Toast",Toast.LENGTH_SHORT).show();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"This is Fab Toast",Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"This is Another Toast",Toast.LENGTH_SHORT).show();
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,"This is Toast",Toast.LENGTH_SHORT).show();


            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("life","start");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("life","resume");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("life","stop");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("life","pause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("life","restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("life","destroy");
    }
}