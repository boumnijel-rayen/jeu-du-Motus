package com.example.motus;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.motus.adapter.CustomTestBaseAdapter;
import com.example.motus.database.Helper;

import java.util.ArrayList;

public class test extends AppCompatActivity {

    ArrayList<String> words = new ArrayList<>();
    ArrayList<Bitmap> images = new ArrayList<>();
    ArrayList<String> IDs = new ArrayList<>();

    ListView listView;

    Helper h = new Helper(test.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        listView = (ListView) findViewById(R.id.testList);
        Cursor c = h.getInGame();
        c.moveToFirst();
        IDs.add(c.getInt(1)+"");

        for (int i = 0; i < IDs.size(); i++) {
            Log.println(Log.ASSERT, "ID", IDs.get(i));
        }

        /*c = h.getOneWord(3);
        c.moveToFirst();
        for(int i = 0; i < c.getCount(); i++){
            byte[] img = c.getBlob(2);
            images.add(BitmapFactory.decodeByteArray(img, 0, img.length));
            c.moveToNext();
        }*/
        CustomTestBaseAdapter customTestBaseAdapter = new CustomTestBaseAdapter(getApplicationContext(), IDs, images);
        listView.setAdapter(customTestBaseAdapter);
    }
}