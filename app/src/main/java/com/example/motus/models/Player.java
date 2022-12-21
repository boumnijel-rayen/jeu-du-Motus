package com.example.motus.models;

public class Player {
    private int id_P;
    private String name;
    private String lastname;
    private String email;
    private int score;

    public Player(int id_P, String name, String lastname, String email, int score) {
        this.id_P = id_P;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.score = score;
    }

    public Player(String name, String lastname, String email, int score) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.score = score;
    }

    public Player(String name, String lastname, int score) {
        this.name = name;
        this.lastname = lastname;
        this.score = score;
    }

    public Player() {
    }

    public int getId_P() {
        return id_P;
    }

    public void setId_P(int id_P) {
        this.id_P = id_P;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
