package com.example.stolt.androideksamen;

import android.database.Cursor;
import android.database.CursorWrapper;

public class BlokWrapper extends CursorWrapper {

    public BlokWrapper(Cursor cursor) {
        super(cursor);
    }

    public Blok getBlokke(){
        long id = getLong(getColumnIndex("_id"));
        long klasseID = getLong(getColumnIndex("KLASSEID"));
        int blokTid = getInt(getColumnIndex("BLOKTID"));
        int uge = getInt(getColumnIndex("UGE"));
        String dag = getString(getColumnIndex("DAG"));


        return new Blok(id, klasseID, blokTid, uge, dag);
    }
}