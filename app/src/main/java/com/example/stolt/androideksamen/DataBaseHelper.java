package com.example.stolt.androideksamen;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "SkemaDB";
    private static final int DB_VERSION = 2;
    private static Context applicationContext;
    private static DataBaseHelper DBHelper;

    public static void setApplicationContext(Context context){
        applicationContext = context.getApplicationContext();
    }

    public DataBaseHelper(Context context){
        super(context,DB_NAME, null, DB_VERSION);}

    public static DataBaseHelper getInstance(){
        if (DBHelper == null) {
            DBHelper = new DataBaseHelper(applicationContext);
        }
        return DBHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        updateMyDatabase(sqLiteDatabase,0,DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }


    public void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion <= 1) {
    //TODO: Eventuelt sætte cascade delete på

            // KLASSE
            db.execSQL("CREATE TABLE KLASSE ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "KLASSENAVN TEXT, "
                    + "SEMESTER INTEGER);");

            // FAG
            db.execSQL("CREATE TABLE FAG ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "FAGNAVN TEXT, "
                    + "ANTALBLOKKE INTEGER, "
                    + "LÆRERID INTEGER);");

            // REFERENCES LÆRER(_id) TODO: Indsættes når læreren skal sættes på et fag
            // BLOK
            db.execSQL("CREATE TABLE BLOK ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "KLASSEID INTEGER REFERENCES KLASSE(_id), "
                    + "FAGID INTEGER REFERENCES FAG(_id), "
                    + "BLOKTID INTEGER, "
                    + "UGE INTEGER, "
                    + "DAG TEXT);");

            // LÆRER
            db.execSQL("CREATE TABLE LÆRER ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "LÆRERNAVN TEXT);");
        }

    }


}
