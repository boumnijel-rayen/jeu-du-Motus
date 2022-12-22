package com.example.motus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView msg;
    ImageView imgRes;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        msg = findViewById(R.id.msg);
        imgRes = findViewById(R.id.imageRes);


        imgRes.setImageResource(R.drawable.win);

        msg.setText("Well done, you are a winner !");

    }
}