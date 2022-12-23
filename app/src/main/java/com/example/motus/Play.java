package com.example.motus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.motus.database.Helper;
import com.example.motus.models.Word;

public class Play extends AppCompatActivity {

    Helper h = new Helper(Play.this);

    TextView LibWord;
    TextView error;
    ImageView imageWord;
    Button tryB;
    EditText tryWord;
    String msgError;
    int nbTry = 7;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        LibWord = findViewById(R.id.LibWord);
        imageWord = findViewById(R.id.imageWord);
        tryB = findViewById(R.id.tryB);
        error = findViewById(R.id.error);
        tryWord = findViewById(R.id.wordInput);

        int min = 1;
        int max = 6;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        Cursor c = h.getOneWord(random_int);
        c.moveToFirst();
        byte[] img = c.getBlob(2);
        Word word = new Word(c.getInt(0),c.getString(1), BitmapFactory.decodeByteArray(img, 0, img.length));

        String libCrypt = word.getLib_word().substring(0,1);
        for(int i= 1; i < word.getLib_word().length(); i++){
            libCrypt += "*";
        }

        LibWord.setText(libCrypt);
        imageWord.setImageBitmap(word.getImage());

        tryB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!tryWord.getText().toString().equals(word.getLib_word())) {
                    nbTry--;
                    msgError = "You have " + nbTry + " try left";
                    error.setText(msgError);
                }else{
                    Intent intent = new Intent(Play.this, Result.class);
                    startActivity(intent);
                }
            }
        });

    }
}