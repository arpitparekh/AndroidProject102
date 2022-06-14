package com.arpitparekh.hardikbhagvatproject.firebase_auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.arpitparekh.hardikbhagvatproject.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();

        binding.tvNewUser.setOnClickListener(view -> {

            startActivity(new Intent(this,RegisterActivity.class));

        });

        binding.btnLogin.setOnClickListener(view -> {

            String email = binding.edtEmailLogin.getText().toString();
            String password = binding.edtPasswordLogin.getText().toString();

            auth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Snackbar.make(binding.edtPasswordLogin,"Success",Snackbar.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Snackbar.make(binding.edtPasswordLogin,e.getMessage(),Snackbar.LENGTH_SHORT).show();
                }
            });


        });

    }
}