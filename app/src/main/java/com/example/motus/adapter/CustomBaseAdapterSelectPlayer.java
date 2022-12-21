package com.example.motus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.motus.R;
import com.example.motus.models.Player;

import java.util.ArrayList;

public class CustomBaseAdapterSelectPlayer extends BaseAdapter {

    Context context;
    LayoutInflater inflter;
    ArrayList<Player> players = new ArrayList<>();

    public CustomBaseAdapterSelectPlayer(Context applicationContext, ArrayList<Player> players) {
        this.context = applicationContext;
        this.players = players;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return players.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_custom_select_player_list, null);
        TextView name = (TextView) view.findViewById(R.id.nameSP);
        TextView email = (TextView) view.findViewById(R.id.emailSP);
        name.setText(players.get(i).getName()+" "+players.get(i).getLastname());
        email.setText(players.get(i).getEmail());
        return view;
    }
}
