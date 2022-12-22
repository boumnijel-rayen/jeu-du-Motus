package com.example.motus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.motus.database.Helper;
import com.example.motus.models.Word;

public class MainActivity extends AppCompatActivity {

    Button startPlay;
    Button ranking;

    Helper h = new Helper(MainActivity.this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startPlay = (Button) findViewById(R.id.start);
        ranking = (Button) findViewById(R.id.ranking);

        startPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, startPlay.class);
                startActivity(i);
            }
        });

        ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, test.class);
                startActivity(i);
            }
        });
    }
}