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

public class CustomBaseAdapterRanking extends BaseAdapter {

    Context context;
    ArrayList<Player> players = new ArrayList<>();
    LayoutInflater inflater;

    public CustomBaseAdapterRanking(Context context, ArrayList<Player> players) {
        this.context = context;
        this.players = players;
        inflater = LayoutInflater.from(context);
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
        view = inflater.inflate(R.layout.activity_custom_ranking_list, null);
        TextView name = view.findViewById(R.id.name);
        TextView score = view.findViewById(R.id.score);
        TextView rank = view.findViewById(R.id.rank);
        name.setText(players.get(i).getName()+" "+players.get(i).getLastname());
        score.setText(String.valueOf(players.get(i).getScore()));
        rank.setText(String.valueOf(i + 1));
        return view;
    }
}
