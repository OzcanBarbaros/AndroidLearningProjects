package com.ozcan.moviebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ozcan.moviebook.databinding.ActivityDetailsBinding;


public class DetailsActivity extends AppCompatActivity {
    private ActivityDetailsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();

        Movies selectedMovies = (Movies) intent.getSerializableExtra("movies");

        binding.nameText.setText(selectedMovies.name);
        binding.genreText.setText(selectedMovies.genre);
        binding.imageView.setImageResource(selectedMovies.image);
    }
}