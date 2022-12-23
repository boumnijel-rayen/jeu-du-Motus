package com.example.motus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.motus.adapter.CustomBaseAdapterSelectPlayer;
import com.example.motus.database.Helper;
import com.example.motus.models.Player;

import java.util.ArrayList;

public class SelectPlayer extends AppCompatActivity {

    ArrayList<Player> players = new ArrayList<>();

    ListView listView;
    Button playSP;

    Helper h = new Helper(SelectPlayer.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_player);

        playSP = findViewById(R.id.playSP);

        Cursor c = h.getPlayers();
        c.moveToFirst();
        while (!c.isAfterLast()) {
            Player p = new Player(c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getInt(4));
            players.add(p);
            c.moveToNext();
        }

        listView = findViewById(R.id.listViewSelectPlayer);

        final int[] id = new int[1];

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                id[0] = players.get(i).getId_P();
                Toast.makeText(getApplicationContext(), "Selected Player "+players.get(i).getName()+" "+players.get(i).getLastname(), Toast.LENGTH_LONG).show();
            }
        });

        playSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                h.updateInGame(id[0]);
                if (id[0] != 0) {
                    Intent intent = new Intent(SelectPlayer.this, Play.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Please select a player", Toast.LENGTH_LONG).show();
                }
            }
        });

        CustomBaseAdapterSelectPlayer customBaseAdapterSelectPlayer = new CustomBaseAdapterSelectPlayer(getApplicationContext(), players);
        listView.setAdapter(customBaseAdapterSelectPlayer);
    }
}