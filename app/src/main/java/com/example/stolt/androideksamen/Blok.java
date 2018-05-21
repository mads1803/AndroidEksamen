package com.example.stolt.androideksamen;

public class Blok {
    private long id;
    private long klasseID;
    private long fagID;
    private int blokTid;
    private int uge;
    private String dag;


    public Blok(long klasseID, long fagID, int blokTid, int uge, String dag) {
        this(-1, klasseID, fagID, blokTid, uge, dag);
    }

    public Blok(long id, long klasseID, long fagID, int blokTid, int uge, String dag) {
        this.klasseID = klasseID;
        this.blokTid = blokTid;
        this.id = id;
        this.uge = uge;
        this.dag = dag;
        this.fagID = fagID;
    }
}
