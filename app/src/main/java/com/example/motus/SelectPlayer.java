package com.example.motus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.motus.adapter.CustomBaseAdapterSelectPlayer;
import com.example.motus.models.Player;

import java.util.ArrayList;

public class SelectPlayer extends AppCompatActivity {

    ArrayList<Player> players = new ArrayList<>();

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_player);

        players.add(new Player("Jhon", "Redrigez", "JohnRedrigez@gmail.com", 80));
        players.add(new Player("Rayen", "Boumnijel", "RayenBoumnijel@gmail.com", 100));
        players.add(new Player("Karim", "Benzima", "KarimBenzima@gmail.com", 90));
        players.add(new Player("Neymar", "Jr", "NeymarJr@gmail.com", 70));

        listView = findViewById(R.id.listViewSelectPlayer);

        CustomBaseAdapterSelectPlayer customBaseAdapterSelectPlayer = new CustomBaseAdapterSelectPlayer(getApplicationContext(), players);
        listView.setAdapter(customBaseAdapterSelectPlayer);
    }
}