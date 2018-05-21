package com.example.stolt.androideksamen;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Storage {
    private static Storage storage;
    private static DataBaseHelper DBHelper = DataBaseHelper.getInstance();

    public static Storage getInstance(){
        if(storage == null){
            storage = new Storage();
            storage.addDummyData();
        }
        return storage;
    }

    //---- Insert metoder
    public static void insertKlasse(String klasseNavn, int semester){
        SQLiteDatabase db = DBHelper.getWritableDatabase();
        ContentValues klasseValues = new ContentValues();
        klasseValues.put("KLASSENAVN", klasseNavn);
        klasseValues.put("SEMESTER", semester);
        db.insert("KLASSE", null, klasseValues);
    }

    public static void insertBlok(long klasseID, long fagID, int blokTid, int uge, String dag){
        SQLiteDatabase db = DBHelper.getWritableDatabase();
        ContentValues blokValues = new ContentValues();
        blokValues.put("KLASSEID", klasseID);
        blokValues.put("BLOKTID", blokTid);
        blokValues.put("FAGID", fagID);
        blokValues.put("UGE", uge);
        blokValues.put("DAG",  dag);
        db.insert("BLOK", null, blokValues);
    }

    //--- Get metoder
    public KlasseWrapper getKlasser(){
        SQLiteDatabase db = DBHelper.getReadableDatabase();
        Cursor cursor =  db.query("KLASSE",
                new String[]{"_id", "KLASSENAVN", "SEMESTER"},
                null, null, null, null, null, null);
        return new KlasseWrapper(cursor);
    }

    public BlokWrapper getBlokke(long klasse_id){
        SQLiteDatabase db = DBHelper.getReadableDatabase();
        Cursor cursor =  db.query("BLOK",
                new String[]{"_id", "KLASSEID", "FAGID", "BLOKTID", "UGE", "DAG"},
                "KLASSEID = " + klasse_id, null, null, null, null, null);
        return new BlokWrapper(cursor);
    }



    //Testdata
    public void addDummyData(){

        if (getKlasser().getCount() == 0) {

            insertKlasse("1f", 1);
            insertKlasse("2f", 2);
            insertKlasse("3f", 3);

            insertBlok(1, 1,1,35,"Friday");
        }
    }

}
