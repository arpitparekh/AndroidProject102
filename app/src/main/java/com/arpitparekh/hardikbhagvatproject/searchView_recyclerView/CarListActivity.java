package com.arpitparekh.hardikbhagvatproject.searchView_recyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.arpitparekh.hardikbhagvatproject.R;
import com.arpitparekh.hardikbhagvatproject.databinding.ActivityCarListBinding;

import java.util.ArrayList;

public class CarListActivity extends AppCompatActivity {

    private ActivityCarListBinding binding;
    private ArrayList<Car> list;
    private CarAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCarListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        list = new ArrayList<>();

        list.add(new Car("Kia","celtos",15,5));
        list.add(new Car("Honda","WRV",18,5));
        list.add(new Car("Tata","Herrier",22,7));
        list.add(new Car("Mahindra","X700",20,7));

        binding.rvCarList.setLayoutManager(new LinearLayoutManager(this));

        adapter = new CarAdapter(list);

        binding.rvCarList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);

        MenuItem item = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) item.getActionView();

        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}