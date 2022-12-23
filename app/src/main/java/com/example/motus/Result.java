package com.example.motus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView msg;
    ImageView imgRes;
    Button tryAgain;
    TextView scoreT;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        msg = findViewById(R.id.msg);
        imgRes = findViewById(R.id.imageRes);
        tryAgain = findViewById(R.id.PlayAgainB);
        scoreT = findViewById(R.id.scoreT);

        String score = getIntent().getStringExtra("score");
        String res = getIntent().getStringExtra("result");

        if (res.equals("win")) {
            msg.setText("Well done, you are a winner !");
            scoreT.setText("Your score is : " + score);
            imgRes.setImageResource(R.drawable.win);
        } else {
            msg.setText("You are a looser !");
            scoreT.setText("Your score is : " + score);
            imgRes.setImageResource(R.drawable.lost);
        }

        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Result.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}