package com.example.motus.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.motus.R;

import java.util.ArrayList;

public class CustomTestBaseAdapter extends BaseAdapter {

    Context context;
    ArrayList<Bitmap> images = new ArrayList<>();
    ArrayList<String> words = new ArrayList<>();
    ArrayList<String> IDs = new ArrayList<>();
    LayoutInflater inflter;

    public CustomTestBaseAdapter(Context context, ArrayList<String> IDs, ArrayList<Bitmap> images) {
        this.context = context;
        this.IDs = IDs;
        this.images = images;
        inflter = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return words.size();
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
        view = inflter.inflate(R.layout.activity_custom_test, null);
        TextView word = (TextView) view.findViewById(R.id.word);
        ImageView imageWord = (ImageView) view.findViewById(R.id.imageView);
        TextView id = (TextView) view.findViewById(R.id.idW);
        word.setText(IDs.get(i));
        id.setText(IDs.get(i));
        imageWord.setImageBitmap(images.get(i));
        return view;
    }
}
