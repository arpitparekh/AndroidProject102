package com.arpitparekh.hardikbhagvatproject.room_crud;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.arpitparekh.hardikbhagvatproject.databinding.ActivityEmpList2Binding;
import com.arpitparekh.hardikbhagvatproject.databinding.ActivityEmpListBinding;
import com.arpitparekh.hardikbhagvatproject.databinding.EmpUpdateDialogBinding;

import java.util.ArrayList;
import java.util.List;

public class EmpListActivity extends AppCompatActivity {

    private ActivityEmpList2Binding binding;
    private EmpUpdateDialogBinding dialogBinding;
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

        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                dialogBinding = EmpUpdateDialogBinding.inflate(getLayoutInflater());

                Emp emp = list.get(pos);

                dialogBinding.edtNameUpdate.setText(emp.name);
                dialogBinding.edtAddressUpdate.setText(emp.address);

                new AlertDialog.Builder(EmpListActivity.this)
                        .setTitle("Choose One")
                        .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {


                                new AlertDialog.Builder(EmpListActivity.this)
                                        .setTitle("Update")
                                        .setView(dialogBinding.getRoot())
                                        .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                String name = dialogBinding.edtNameUpdate.getText().toString();
                                                String address = dialogBinding.edtAddressUpdate.getText().toString();

                                                emp.name = name;
                                                emp.address = address;
                                                dao.updateData(emp);

                                                getData();

                                            }
                                        }).create().show();

                            }
                        })
                        .setNeutralButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dao.deleteData(emp);

                                getData();

                            }
                        }).create().show();


            }
        });

        binding.btnSend.setOnClickListener(view -> {

            String name = binding.edtName.getText().toString();
            String address = binding.edtAddress.getText().toString();

            Emp e = new Emp(name,address);

            dao.insertData(e);

            getData();

        });

    }

    private void getData() {

        list = dao.showData();  // select*from

        ArrayAdapter<Emp> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);

        binding.listView.setAdapter(adapter);

    }
}