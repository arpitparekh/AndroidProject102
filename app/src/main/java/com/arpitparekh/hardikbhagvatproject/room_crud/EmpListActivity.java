package com.arpitparekh.hardikbhagvatproject.room_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.arpitparekh.hardikbhagvatproject.databinding.ActivityEmpList2Binding;
import com.arpitparekh.hardikbhagvatproject.databinding.ActivityEmpListBinding;

import java.util.ArrayList;
import java.util.List;

public class EmpListActivity extends AppCompatActivity {

    private ActivityEmpList2Binding binding;
    private EmpDao dao;
    private List<Emp> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmpList2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        dao = DatabaseHelper.getDatabase(this).getDao();

        getData();

        binding.btnSend.setOnClickListener(view -> {

            String name = binding.edtName.getText().toString();
            String address = binding.edtAddress.getText().toString();

            Emp e = new Emp(name,address);

            dao.insertData(e);

            getData();

        });

    }

    private void getData() {

        list = dao.showData();

        ArrayAdapter<Emp> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);

        binding.listView.setAdapter(adapter);

    }
}