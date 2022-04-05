package com.arpitparekh.hardikbhagvatproject.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.arpitparekh.hardikbhagvatproject.R;
import com.arpitparekh.hardikbhagvatproject.databinding.ActivityMyDialogBinding;
import com.arpitparekh.hardikbhagvatproject.databinding.DialogLayoutBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MyDialogActivity extends AppCompatActivity {

    private ActivityMyDialogBinding binding;
    private DialogLayoutBinding binding1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String items[] = {"Car","Bike","plane","metro","Bus","Rickshaw","Submarine","Jet","Elephant"};
        boolean check[]={true,true,false,true,true,false,false,false,false};
        ArrayList<String> vehicles = new ArrayList<>();

        vehicles.add(items[0]);
        vehicles.add(items[1]);
        vehicles.add(items[3]);
        vehicles.add(items[4]);

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

        binding.btnTime.setOnClickListener(view -> {

            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minuet = calendar.get(Calendar.MINUTE);

            TimePickerDialog dialog = new TimePickerDialog(this,(timePicker, i, i1) -> {

//                binding.btnTime.setText(i+":"+i1);  // 24 hrs

                String hr24 = i+":"+i1;

                SimpleDateFormat format24 = new SimpleDateFormat("HH:mm");
                SimpleDateFormat format12 = new SimpleDateFormat("hh:mm a");

                try {

                    Date date24 = format24.parse(hr24);

                    String hr12 = format12.format(date24);

                    binding.btnTime.setText(hr12);

                } catch (ParseException e) {
                    e.printStackTrace();
                }


            },hour,minuet,true);

            dialog.show();

        });

        binding.btnDate.setOnClickListener(view -> {

            Calendar calendar = Calendar.getInstance();

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(this,(datePicker, i, i1, i2) -> {

                binding.btnDate.setText(i2+"/"+(i1+1)+"/"+i);

            },year,month,day);

            dialog.show();

        });

        binding.btnFullScreen.setOnClickListener(view -> {

            binding1 = DialogLayoutBinding.inflate(getLayoutInflater());

            Dialog dialog = new Dialog(this, android.R.style.Theme_Light_NoTitleBar_Fullscreen);

            dialog.setContentView(binding1.getRoot());

            dialog.show();

        });

        binding.btnMultiChoiceDialog.setOnClickListener(view -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMultiChoiceItems(items,check,(dialogInterface, i, b) -> {

                if(b){

                    vehicles.add(items[i]);

                }else{

                    vehicles.remove(items[i]);
                }
                Toast.makeText(MyDialogActivity.this, vehicles.toString(), Toast.LENGTH_SHORT).show();

            });



            builder.show();

        });

        binding.btnSingleChoice.setOnClickListener(view -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setSingleChoiceItems(items,0,(dialogInterface, i) -> {

                Toast.makeText(this, items[i], Toast.LENGTH_SHORT).show();

            });

            builder.show();

        });

    }
}