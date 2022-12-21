package com.example.motus.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Helper extends SQLiteOpenHelper {

    public Helper(@Nullable Context context) {
        super(context, "MOTUS", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE PLAYER (id_P INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, lastName TEXT, email TEXT, score INTEGER)");
        sqLiteDatabase.execSQL("CREATE TABLE WORD (id_W INTEGER PRIMARY KEY AUTOINCREMENT, lib_W TEXT, image BLOB)");
        sqLiteDatabase.execSQL("CREATE TABLE INGAME (id_G INTEGER PRIMARY KEY AUTOINCREMENT, id_Player INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PLAYER");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS WORD");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS INGAME");
        onCreate(sqLiteDatabase);
    }
}
