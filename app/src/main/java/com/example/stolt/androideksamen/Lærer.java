package com.example.stolt.androideksamen;

public class Lærer {
    private long id;
    private String lærerNavn;

    public Lærer(String lærerNavn) {
        this(-1, lærerNavn);
    }

    public Lærer(long id, String lærerNavn) {
        this.lærerNavn = lærerNavn;
        this.id = id;
    }
}
