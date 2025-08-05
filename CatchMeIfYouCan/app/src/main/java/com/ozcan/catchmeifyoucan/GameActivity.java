package com.ozcan.catchmeifyoucan;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    TextView timeText, scoreText;
    ImageView character;
    Runnable runnable;
    Handler handler;
    int maxWidth;
    int maxHeight;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_game);

        timeText = findViewById(R.id.textView2);
        scoreText = findViewById(R.id.textView3);
        character = findViewById(R.id.imageView3);

        startGame();


        character.setOnClickListener(v -> {
            score++;
            scoreText.setText("Score:" +score);
        });
    }

    private void startGame(){
        score = 0;
        scoreText.setText("Score:" +score);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                moveCharacterRandomly();
                handler.postDelayed(this, 500);
            }
        };
        handler.post(runnable);

        new CountDownTimer(10000, 1000){
            public void onTick(long millisUntilFinished) {
                timeText.setText("Time Left:" +millisUntilFinished/1000);
            }

            public void onFinish(){
                timeText.setText("Time Finished");
                handler.removeCallbacks(runnable);
                character.setVisibility(View.INVISIBLE);
                showRestartDialog();
            }
        }.start();
    }


    private void moveCharacterRandomly(){

        if (maxWidth <= 0 || maxHeight <= 0) {
            // Ekran ölçüleri hazır değil, pozisyon verme!
            return;
        }

        Random random = new Random();
        float randomX = random.nextInt(maxWidth);
        float randomY = random.nextInt(maxHeight);

        character.setX(randomX);
        character.setY(randomY);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            maxWidth = findViewById(R.id.mainLayout).getWidth() - character.getWidth();
            maxHeight = findViewById(R.id.mainLayout).getHeight() - character.getHeight();
        }
    }


    private void showRestartDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Game Over")
                .setMessage("Score: " + score + "\nRestart game?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    recreate();
                })
                .setNegativeButton("No", (dialog, which) -> {
                    finish(); // Oyunu kapatır, ana menüye döner
                })
                .setCancelable(false)
                .show();
    }
}