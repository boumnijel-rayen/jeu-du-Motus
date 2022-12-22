package com.example.motus.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import androidx.annotation.Nullable;

import com.example.motus.models.Player;
import com.example.motus.models.Word;

import java.io.ByteArrayOutputStream;

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

    public void addPlayer(Player player){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", player.getName());
        contentValues.put("lastName", player.getLastname());
        contentValues.put("email", player.getEmail());
        contentValues.put("score", player.getScore());
        db.insert("PLAYER", null, contentValues);
        db.close();
    }

    public void addWord(Word word){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        word.getImage().compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] img = stream.toByteArray();
        contentValues.put("lib_W", word.getLib_word());
        contentValues.put("image", img);
        db.insert("WORD", null, contentValues);
        db.close();
    }

    public void addInGame(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id_G", 1);
        db.insert("INGAME", null, contentValues);
        db.close();
    }

    public Cursor getPlayers(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM PLAYER", null);
        return cursor;
    }

    public Cursor getWords(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM WORD", null);
        return cursor;
    }

    public Cursor getAllInGame(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM INGAME", null);
        return cursor;
    }

    public Cursor getInGame(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("INGAME", new String[]{"id_G", "id_Player"}, "id_G = ?", new String[]{"1"}, null, null, null);
        return cursor;
    }

    public void updatePlayer(Player player){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("score", player.getScore());
        db.update("PLAYER", contentValues, "id_P = ?", new String[]{String.valueOf(player.getId_P())});
        db.close();
    }

    public void updateInGame(int id_Player){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id_Player", id_Player);
        db.update("INGAME", contentValues, "id_G = ?", new String[]{String.valueOf(1)});
        db.close();
    }

    public void deletePlayer(int id_Player){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("PLAYER", "id_P = ?", new String[]{String.valueOf(id_Player)});
        db.close();
    }

    public void deleteInGame(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("INGAME", "id_G = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public void deleteWord(int id_Word){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("WORD", "id_W = ?", new String[]{String.valueOf(id_Word)});
        db.close();
    }

    public Cursor getOneWord(int id_Word){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("WORD", new String[]{"id_W", "lib_W", "image"}, "id_W = ?", new String[]{String.valueOf(id_Word)}, null, null, null);
        return cursor;
    }



}
