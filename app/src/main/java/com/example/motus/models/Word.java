package com.example.motus.models;

import android.graphics.Bitmap;

public class Word {
    private int id_W;
    private String lib_word;
    private Bitmap image;

    public Word(int id_W, String lib_word, Bitmap image) {
        this.id_W = id_W;
        this.lib_word = lib_word;
        this.image = image;
    }

    public Word(String lib_word, Bitmap image) {
        this.lib_word = lib_word;
        this.image = image;
    }

    public Word() {
    }

    public int getId_W() {
        return id_W;
    }

    public void setId_W(int id_W) {
        this.id_W = id_W;
    }

    public String getLib_word() {
        return lib_word;
    }

    public void setLib_word(String lib_word) {
        this.lib_word = lib_word;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
