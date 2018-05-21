package com.example.stolt.androideksamen;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class UgeListeActivity extends AppCompatActivity {
    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uge_liste);

        mainListView = (ListView) findViewById( R.id.uge_liste );

        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        // Indsætter ugerne
        for(int i=34; i<=51; i++){
            listAdapter.add("Uge: " + i);
        }

        mainListView.setAdapter( listAdapter );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.klasse_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_tilbage:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
