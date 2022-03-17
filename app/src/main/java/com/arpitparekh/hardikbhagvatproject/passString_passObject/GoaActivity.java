package com.arpitparekh.hardikbhagvatproject.passString_passObject;

import androidx.appcompat.app.AppCompatActivity;
import com.arpitparekh.hardikbhagvatproject.R;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GoaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goa);

        TextView tv = findViewById(R.id.tvString);

        Intent i = getIntent();

//        String returnStr = i.getStringExtra("stuff");

//        tv.setText(returnStr);

            Student s = (Student) i.getSerializableExtra("object");

            tv.setText(s.name+"\n"+s.email);

    }
}