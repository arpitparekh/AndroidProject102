package com.arpitparekh.hardikbhagvatproject.adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.arpitparekh.hardikbhagvatproject.databinding.ActivityStudentListBinding;

import java.util.ArrayList;

public class StudentListActivity extends AppCompatActivity {

    private ActivityStudentListBinding binding;
    private ArrayList<String> list;
    private boolean update = false;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        // adapter
        // ArrayAdapter
        // Simple Adapter
        // RecyclerView Adapter

        // ArrayAdapter

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 ,list);

        binding.listViewStudents.setAdapter(adapter);

        binding.btnAdd.setOnClickListener(view -> {

            String studentName = binding.edtStudentName.getText().toString();

            if(update){

                // update

                String updatedString = binding.edtStudentName.getText().toString();

                list.set(position,updatedString);

                adapter.notifyDataSetChanged();

                update = false;

                binding.btnAdd.setText("Add");


            }else{

                // insert

                if(!studentName.isEmpty()){
                    list.add(studentName);
                }

            }
            adapter.notifyDataSetChanged();
            binding.edtStudentName.setText("");
        });

        binding.listViewStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                String data = list.get(pos);

                new AlertDialog.Builder(StudentListActivity.this)
                        .setTitle("Choose One")
                        .setPositiveButton("Update",(dialogInterface, i) -> {
                            //update

                            binding.edtStudentName.setText(data);

                            update = true;

                            position = pos;

                            binding.btnAdd.setText("Update");


                        })
                        .setNeutralButton("Delete",(dialogInterface, i) -> {
                            // delete

                            list.remove(data);

                            adapter.notifyDataSetChanged();

                        }).create().show();
            }
        });

    }
}