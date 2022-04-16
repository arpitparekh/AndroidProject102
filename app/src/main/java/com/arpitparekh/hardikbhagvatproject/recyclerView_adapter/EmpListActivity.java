package com.arpitparekh.hardikbhagvatproject.recyclerView_adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.arpitparekh.hardikbhagvatproject.databinding.ActivityEmpListBinding;

import java.util.ArrayList;

public class EmpListActivity extends AppCompatActivity {

    private ActivityEmpListBinding binding;
    private ArrayList<Emp> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmpListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recyclerViewEmp.setLayoutManager(new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL));

        list = new ArrayList<>();

        EmpAdapter adapter = new EmpAdapter(list);

        binding.recyclerViewEmp.setAdapter(adapter);

        binding.btnAdd.setOnClickListener(view -> {

            String name= binding.edtName.getText().toString();
            String address= binding.edtAddress.getText().toString();
            String salary= binding.edtSalary.getText().toString();

            Emp e = new Emp(name,address,Long.parseLong(salary));

            list.add(e);

            adapter.notifyDataSetChanged();

        });


    }
}