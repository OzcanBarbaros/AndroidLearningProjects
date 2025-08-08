package com.ozcan.moviebook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ozcan.moviebook.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView .Adapter<MoviesAdapter.MoviesHolder>{
    ArrayList<Movies> moviesArrayList;

    public MoviesAdapter(ArrayList<Movies> moviesArrayList) {
        this.moviesArrayList = moviesArrayList;
    }

    @NonNull
    @Override
    public MoviesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new MoviesHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesHolder holder, int position) {

        holder.binding.recyclerRowTextView.setText(moviesArrayList.get(position).name);

    }

    @Override
    public int getItemCount() {
        return moviesArrayList.size();
    }

    public class MoviesHolder extends RecyclerView.ViewHolder {

        private RecyclerRowBinding binding;

        public MoviesHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
