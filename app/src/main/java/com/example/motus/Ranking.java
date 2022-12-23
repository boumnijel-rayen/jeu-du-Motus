package com.example.motus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import com.example.motus.adapter.CustomBaseAdapterRanking;
import com.example.motus.database.Helper;
import com.example.motus.models.Player;

import java.util.ArrayList;

public class Ranking extends AppCompatActivity {

    ArrayList<Player> players = new ArrayList<>();

    ListView listView;

    Helper h = new Helper(Ranking.this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        Cursor c = h.getPlayersOrdered();
        c.moveToFirst();
        while (!c.isAfterLast()) {
            players.add(new Player(c.getString(1), c.getString(2), c.getString(3), c.getInt(4)));
            c.moveToNext();
        }

        listView = findViewById(R.id.listViewRanking);
        CustomBaseAdapterRanking customBaseAdapterRanking = new CustomBaseAdapterRanking(getApplicationContext(), players);
        listView.setAdapter(customBaseAdapterRanking);
    }
}