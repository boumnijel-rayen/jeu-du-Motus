package com.example.motus;

import androidx.appcompat.app.AppCompatActivity;

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

        players.add(new Player(1,"Jhon", "Redrigez", "JohnRedrigez@gmail.com", 80));
        players.add(new Player(2,"Rayen", "Boumnijel", "RayenBoumnijel@gmail.com", 100));
        players.add(new Player(3,"Karim", "Benzima", "KarimBenzima@gmail.com", 90));
        players.add(new Player(4,"Neymar", "Jr", "NeymarJr@gmail.com", 70));

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
                Log.println(Log.INFO, "id Player =", id[0] +"");
                h.updateInGame(id[0]);
            }
        });

        CustomBaseAdapterSelectPlayer customBaseAdapterSelectPlayer = new CustomBaseAdapterSelectPlayer(getApplicationContext(), players);
        listView.setAdapter(customBaseAdapterSelectPlayer);
    }
}