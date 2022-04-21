package com.arpitparekh.hardikbhagvatproject.gallery_recyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arpitparekh.hardikbhagvatproject.databinding.GalleryRowItemBinding;
import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    ArrayList<Gallery> list;
    Context context;

    GalleryAdapter(ArrayList<Gallery> list){

        this.list = list;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        GalleryRowItemBinding binding = GalleryRowItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new GalleryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {

        Gallery g = list.get(position);

//        Glide.with(context).load(g.url).into(holder.binding.ivPhoto);

        holder.binding.ivPhoto.setImageResource(g.id);

        holder.itemView.setOnClickListener(view -> {

            Intent i = new Intent(context,ShowDataActivity.class);
            i.putExtra("position",position);

            Bundle b = new Bundle();
            b.putSerializable("list",list);

            i.putExtra("bundle",b);
            context.startActivity(i);

        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class GalleryViewHolder extends RecyclerView.ViewHolder {

        GalleryRowItemBinding binding;

        public GalleryViewHolder(@NonNull GalleryRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
