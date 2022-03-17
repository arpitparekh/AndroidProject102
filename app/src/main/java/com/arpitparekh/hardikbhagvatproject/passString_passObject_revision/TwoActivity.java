package com.arpitparekh.hardikbhagvatproject.passString_passObject_revision;

import androidx.appcompat.app.AppCompatActivity;
import com.arpitparekh.hardikbhagvatproject.R;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        TextView tv = findViewById(R.id.tvStringFrom);
        TextView tv2 = findViewById(R.id.tvObjectFrom);

        Intent i = getIntent();


        String myString = i.getStringExtra("string");

        Emp e = (Emp) i.getSerializableExtra("object");

        tv.setText(myString);

        if(e!=null){
            tv2.setText(e.name+" "+e.address);
        }


    }
}