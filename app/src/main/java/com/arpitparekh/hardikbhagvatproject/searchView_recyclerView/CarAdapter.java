package com.arpitparekh.hardikbhagvatproject.searchView_recyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arpitparekh.hardikbhagvatproject.databinding.CarRowItemBinding;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> implements Filterable {

    ArrayList<Car> list;
    ArrayList<Car> copyList;
    ArrayList<Car> filteredList=new ArrayList<>();  // empty array

    CarAdapter(ArrayList<Car> list){

        this.list = list;
        copyList = list;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        CarRowItemBinding binding = CarRowItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new CarViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car c = list.get(position);

        holder.binding.setObj(c);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                if(charSequence.toString().equals("")){

                    filteredList = copyList;

                }else{

                    filteredList = new ArrayList<>(); // empty the filtered list again

                    for(Car c : copyList){

                        if(c.name.toLowerCase().contains(charSequence.toString().toLowerCase()) ||
                                c.model_name.toLowerCase().contains(charSequence.toString().toLowerCase()) ||
                        String.valueOf(c.average).contains(charSequence.toString()) ||
                                String.valueOf(c.no_of_seat).contains(charSequence.toString())){

                            filteredList.add(c);

                        }
                    }
                }
                FilterResults results = new FilterResults();
                results.values = filteredList;

                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                list = (ArrayList<Car>) filterResults.values;

                notifyDataSetChanged();

            }
        };
    }

    public class CarViewHolder extends RecyclerView.ViewHolder {
        CarRowItemBinding binding;
        public CarViewHolder(@NonNull CarRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
