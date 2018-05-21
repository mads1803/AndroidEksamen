package com.example.stolt.androideksamen;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Debug;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import java.io.File;
import java.time.LocalDateTime;

public class MainActivity extends AppCompatActivity {
    private Storage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBaseHelper.setApplicationContext(this);

        storage = Storage.getInstance();
        if(doesDataBaseExist(this, "SkemaDB")==false){
            Log.v("Database", "Fail");
        }

        Button fab1 = (Button) findViewById(R.id.button);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, KalenderActivity.class));
            }
        });

    }


    private static boolean doesDataBaseExist(Context context, String dbName){
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();

    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Afslut App?")
                .setMessage("Er du sikker på, at du vil afslutte?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        MainActivity.super.onBackPressed();
                    }
                }).create().show();
    }

}
