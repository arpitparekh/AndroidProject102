package com.arpitparekh.hardikbhagvatproject.recyclerView_adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arpitparekh.hardikbhagvatproject.databinding.EmpRowItemBinding;

import java.util.ArrayList;

public class EmpAdapter extends RecyclerView.Adapter<EmpAdapter.EmpViewHolder> {

    ArrayList<Emp> list;

    EmpAdapter(ArrayList<Emp> list){

        this.list = list;
    }

    @NonNull
    @Override
    public EmpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // make individual item layout
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        EmpRowItemBinding binding = EmpRowItemBinding.inflate(inflater,parent,false);
        EmpViewHolder holder = new EmpViewHolder(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull EmpViewHolder holder, int position) {

        // add data inside individual item
        Emp e = list.get(position);

        holder.binding.setObj(e);


    }

    @Override
    public int getItemCount() {

        // display total item

        return list.size();
    }

    public class EmpViewHolder extends RecyclerView.ViewHolder {

        EmpRowItemBinding binding;

        public EmpViewHolder(@NonNull EmpRowItemBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
