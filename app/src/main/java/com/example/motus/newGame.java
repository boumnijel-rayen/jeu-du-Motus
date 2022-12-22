package com.example.motus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class newGame extends AppCompatActivity {

    Button submitB;
    EditText nameE, lastNameE, emailE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        submitB = findViewById(R.id.submitB);
        nameE = findViewById(R.id.inputName);
        lastNameE = findViewById(R.id.inputLastname);
        emailE = findViewById(R.id.inputEmail);

        submitB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(newGame.this, Play.class);
                startActivity(intent);
            }
        });
    }
}