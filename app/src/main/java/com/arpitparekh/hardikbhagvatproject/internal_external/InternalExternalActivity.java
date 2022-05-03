package com.arpitparekh.hardikbhagvatproject.internal_external;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.widget.Toast;

import com.arpitparekh.hardikbhagvatproject.databinding.ActivityInternalExternalBinding;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class InternalExternalActivity extends AppCompatActivity {

    private ActivityInternalExternalBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInternalExternalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnInternalStore.setOnClickListener(view -> {

            String data = binding.edtStore.getText().toString();

            try {

                FileOutputStream fos = openFileOutput("dance.txt",MODE_PRIVATE);
                fos.write(data.getBytes());
                fos.close();

                Toast.makeText(this, "Data Write in Internal Storage", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }


        });

        binding.btnFetchInternal.setOnClickListener(view -> {

            try {

                FileInputStream fis = openFileInput("dance.txt");
                byte arr[] = new byte[fis.available()];
                fis.read(arr);

                String data = new String(arr);

                binding.tvInternal.setText(data);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        binding.btnStoreExternal.setOnClickListener(view -> {

            checkPermission();

            File externalFolder = Environment.getExternalStorageDirectory();

            File file = new File(externalFolder,"dance.txt");

            try {

                FileOutputStream fos = new FileOutputStream(file);
                fos.write(binding.edtStore.getText().toString().getBytes());
                fos.close();

                Toast.makeText(this, "File Write External", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        binding.btnFetchExternal.setOnClickListener(view -> {

            checkPermission();

            File externalFolder = Environment.getExternalStorageDirectory();

            File file = new File(externalFolder,"dance.txt");

            try {

                FileInputStream fis = new FileInputStream(file);
                byte arr[] = new byte[fis.available()];
                fis.read(arr);
                String data = new String(arr);
                binding.tvExternal.setText(data);

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    void checkPermission(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){

            if(!Environment.isExternalStorageManager()){

                Intent i = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                i.setData(Uri.fromParts("package",getPackageName(),null));
                startActivity(i);

            }

        }else{

            if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){

                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},101);

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==101){

            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }else{
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},101);
            }
        }
    }
}