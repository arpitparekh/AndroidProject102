package com.arpitparekh.hardikbhagvatproject.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.arpitparekh.hardikbhagvatproject.R;
import com.arpitparekh.hardikbhagvatproject.databinding.ActivityMyDialogBinding;
import com.arpitparekh.hardikbhagvatproject.databinding.DialogLayoutBinding;

public class MyDialogActivity extends AppCompatActivity {

    private ActivityMyDialogBinding binding;
    private DialogLayoutBinding binding1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAlert.setOnClickListener(view -> {

           AlertDialog.Builder builder = new AlertDialog.Builder(this);

           builder.setTitle("Alert Dialog");

           builder.setMessage("Messages");

           builder.setCancelable(false);

           builder.setPositiveButton("Toast",(dialogInterface, i) -> {

               Toast.makeText(this,"Toast From Dialog",Toast.LENGTH_SHORT).show();

           });

           builder.setNegativeButton("Image",(dialogInterface, i) -> {

               binding.getRoot().setBackgroundResource(R.drawable.image);

           });

           builder.setNeutralButton("Cancel",(dialogInterface, i) -> {

               dialogInterface.dismiss();

           });

           builder.show();

        });

        binding.btnAlert1.setOnClickListener(view -> {

            binding1 = DialogLayoutBinding.inflate(getLayoutInflater());

            new AlertDialog.Builder(this)
                    .setTitle("This is Title")
                    .setView(binding1.getRoot())
                    .setPositiveButton("Yes",(dialogInterface, i) -> {

                        String str = binding1.edtDialog.getText().toString();

                        binding.btnAlert1.setText(str);

                    }).create().show();

        });

        binding.btnProgress.setOnClickListener(view -> {

            ProgressDialog dialog = new ProgressDialog(this);

            dialog.setTitle("Loading");

            dialog.setMessage("Downloading your file");

            dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

            dialog.setButton(DialogInterface.BUTTON_POSITIVE,"Cancel",(dialogInterface, i) -> {


            });

            dialog.show();

        });

        binding.btnProgress1.setOnClickListener(view -> {

           ProgressDialog dialog = new ProgressDialog(this);

           dialog.setTitle("Downloading");

           dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

           dialog.setMax(100);

           new Thread(new Runnable() {
               @Override
               public void run() {

                   for(int i=0;i<=100;i++){

                       dialog.setProgress(i);

                       try {
                           Thread.sleep(200);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }

                       if(i==dialog.getMax()){

                           dialog.dismiss();
                       }
                   }
               }
           }).start();

           dialog.show();


        });



    }
}