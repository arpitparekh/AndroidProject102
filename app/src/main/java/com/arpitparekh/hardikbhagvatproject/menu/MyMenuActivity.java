package com.arpitparekh.hardikbhagvatproject.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupMenu;

import com.arpitparekh.hardikbhagvatproject.R;
import com.arpitparekh.hardikbhagvatproject.databinding.ActivityMyMenuBinding;
import com.google.android.material.snackbar.Snackbar;

public class MyMenuActivity extends AppCompatActivity {

    private ActivityMyMenuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // hide actionbar and navigation button
//        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        // option menu
        // popup menu
        // context menu

        registerForContextMenu(binding.btnContext);

        binding.btnPopup.setOnClickListener(view -> {

            PopupMenu pop = new  PopupMenu(this,view);

            pop.getMenuInflater().inflate(R.menu.my_menu,pop.getMenu());

            pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    itemClick(menuItem);
                    return false;
                }
            });

            pop.show();
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

       itemClick(item);

        return super.onOptionsItemSelected(item);
    }

    void itemClick(MenuItem item){

        switch (item.getItemId()){

            case R.id.action_item1:
                Snackbar.make(binding.getRoot(),"item1",Snackbar.LENGTH_SHORT).show();
//                Button b = new Button(this);
//                b.setText("Add");
//                binding.getRoot().addView(b);
                break;
            case R.id.action_item2:
                Snackbar.make(binding.getRoot(),"item2",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.action_item3:
                Snackbar.make(binding.getRoot(),"item3",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.action_item4:
                Snackbar.make(binding.getRoot(),"item4",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.action_item5:
                Snackbar.make(binding.getRoot(),"item5",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.action_item6:
                Snackbar.make(binding.getRoot(),"item6",Snackbar.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        itemClick(item);
        return super.onContextItemSelected(item);
    }
}