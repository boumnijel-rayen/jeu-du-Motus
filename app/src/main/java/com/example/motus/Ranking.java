package com.example.motus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import com.example.motus.adapter.CustomBaseAdapterRanking;
import com.example.motus.models.Player;

import java.util.ArrayList;

public class Ranking extends AppCompatActivity {

    ArrayList<Player> players = new ArrayList<>();

    ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        players.add(new Player("Jhon", "Redrigez", 80));
        players.add(new Player("Rayen", "Boumnijel", 100));
        players.add(new Player("Karim", "Benzima", 90));
        players.add(new Player("Neymar", "Jr", 70));

        listView = findViewById(R.id.listViewRanking);
        CustomBaseAdapterRanking customBaseAdapterRanking = new CustomBaseAdapterRanking(getApplicationContext(), players);
        listView.setAdapter(customBaseAdapterRanking);
    }
}