package com.example.stolt.androideksamen;

import android.database.Cursor;
import android.database.CursorWrapper;

public class KlasseWrapper extends CursorWrapper {

    public KlasseWrapper(Cursor cursor) {
        super(cursor);
    }

    public Klasse getKlasser(){
        long id = getLong(getColumnIndex("_id"));
        String klasseNavn = getString(getColumnIndex("KLASSENAVN"));
        int semester = getInt(getColumnIndex("SEMESTER"));


        return new Klasse(id, klasseNavn, semester);
    }
}