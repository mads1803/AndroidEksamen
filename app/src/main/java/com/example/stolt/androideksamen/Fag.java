package com.example.stolt.androideksamen;

public class Fag {
    private long id;
    private long lærerID;
    private String fagNavn;
    private int antalBlokke;


    public Fag(String fagNavn, int antalBlokke, long lærerID) {
        this(-1, fagNavn, antalBlokke, lærerID);
    }

    public Fag(long id, String fagNavn, int antalBlokke, long lærerID) {
        this.fagNavn = fagNavn;
        this.antalBlokke = antalBlokke;
        this.id = id;
        this.lærerID = lærerID;
    }
}
