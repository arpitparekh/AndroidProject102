package com.arpitparekh.hardikbhagvatproject.passString_passObject_revision;

import androidx.appcompat.app.AppCompatActivity;
import com.arpitparekh.hardikbhagvatproject.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        Button b = findViewById(R.id.btnSendString);
        Button b2 = findViewById(R.id.btnSendObjectFrom);
        EditText e = findViewById(R.id.edtSend);

        b.setOnClickListener(view -> {

            String data = e.getText().toString();
            Emp em = new Emp("Bhagvat","narola");

            Intent i = new Intent(this,TwoActivity.class);
            i.putExtra("string",data);
            i.putExtra("object",em);
            startActivity(i);

        });






    }
}