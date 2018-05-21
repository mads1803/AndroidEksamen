package com.example.stolt.androideksamen;

public class Klasse {
    private long id;
    private String klasseNavn;
    private int semester;


    public Klasse(String klasseNavn, int semester) {
        this(-1, klasseNavn, semester);
    }

    public Klasse(long id, String klasseNavn, int semester) {
        this.klasseNavn = klasseNavn;
        this.semester = semester;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKlasseNavn() {
        return klasseNavn;
    }

    public void setKlasseNavn(String klasseNavn) {
        this.klasseNavn = klasseNavn;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
