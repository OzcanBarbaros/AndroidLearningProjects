package com.ozcan.moviebook;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ozcan.moviebook.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private  ActivityMainBinding binding;
    ArrayList<Movies> moviesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        moviesArrayList = new ArrayList<>();

        Movies fastFurious = new Movies("Fast And Furious",R.drawable.fast,"Action");
        Movies gladiator = new Movies("Gladiator",R.drawable.glady,"Historical");
        Movies formula = new Movies("Formula1",R.drawable.f1,"Action");
        Movies avatar = new Movies("Avatar",R.drawable.avatar,"Sicence Fiction");

        moviesArrayList.add(fastFurious);
        moviesArrayList.add(gladiator);
        moviesArrayList.add(formula);
        moviesArrayList.add(avatar);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MoviesAdapter moviesAdapter = new MoviesAdapter(moviesArrayList);
        binding.recyclerView.setAdapter(moviesAdapter);

    }
}