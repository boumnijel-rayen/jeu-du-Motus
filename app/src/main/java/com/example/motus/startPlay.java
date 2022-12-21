package com.example.motus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class startPlay extends AppCompatActivity {

    Button already;
    Button newGame;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_play);

        already = findViewById(R.id.already);
        newGame = findViewById(R.id.newGameB);

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(startPlay.this, newGame.class);
                startActivity(intent);
            }
        });

        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(startPlay.this, SelectPlayer.class);
                startActivity(intent);
            }
        });
    }
}