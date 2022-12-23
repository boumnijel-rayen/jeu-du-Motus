package com.example.motus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.motus.database.Helper;
import com.example.motus.models.Player;

public class newGame extends AppCompatActivity {

    Button submitB;
    EditText nameE, lastNameE, emailE;

    Helper h = new Helper(newGame.this);

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
                if (nameE.getText().toString().isEmpty() || lastNameE.getText().toString().isEmpty() || emailE.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please fill all required fields", Toast.LENGTH_LONG).show();
                } else {
                    h.addPlayer(new Player(nameE.getText().toString(), lastNameE.getText().toString(), emailE.getText().toString(),0));
                    int id = h.getLastPlayerId();
                    h.updateInGame(id);
                    Intent intent = new Intent(newGame.this, Play.class);
                    startActivity(intent);
                }
            }
        });
    }
}