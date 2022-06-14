package com.arpitparekh.hardikbhagvatproject.firebase_realtime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.arpitparekh.hardikbhagvatproject.databinding.ActivityFacultyListBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FacultyListActivity extends AppCompatActivity {

    private ActivityFacultyListBinding binding;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFacultyListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ref = FirebaseDatabase.getInstance().getReference("Faculty").child("FacultyData");

        binding.btnAdd.setOnClickListener(view -> {

            String name = binding.edtName.getText().toString();
            String address = binding.edtAddress.getText().toString();

            Faculty faculty = new Faculty(name,address);

            ref.push().setValue(faculty).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {

                    Toast.makeText(FacultyListActivity.this, "Data Added Successfully", Toast.LENGTH_SHORT).show();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(FacultyListActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        });




    }
}