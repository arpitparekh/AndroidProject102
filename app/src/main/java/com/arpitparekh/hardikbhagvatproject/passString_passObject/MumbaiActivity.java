package com.arpitparekh.hardikbhagvatproject.passString_passObject;

import androidx.appcompat.app.AppCompatActivity;
import com.arpitparekh.hardikbhagvatproject.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MumbaiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mumbai);

        // View class parent call of all the child views

        // context is global information

        // this

        Button b = findViewById(R.id.btnSend);
        Button b1 = findViewById(R.id.btnSendObject);

        EditText e = findViewById(R.id.edtString);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data = e.getText().toString();

                // Intent

                Intent i = new Intent(MumbaiActivity.this,GoaActivity.class);
                i.putExtra("stuff",data);
                startActivity(i);

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Student s = new Student("arpit","arpit@gmail.com");

                Intent i = new Intent(MumbaiActivity.this,GoaActivity.class);
                i.putExtra("object",s);
                startActivity(i);

            }
        });


    }
}