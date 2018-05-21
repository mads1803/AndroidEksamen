package com.example.stolt.androideksamen;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class KlasseActivity extends AppCompatActivity {
// TODO: Tage en final string: Om det er Lærer eller klasse som er valgt

    private Storage storage;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klasse);
        initList();

    }

    public  void initList(){
        storage = Storage.getInstance();
        getSupportActionBar().setTitle("Hvem er du?");

        ListView listView = (ListView) findViewById(R.id.klasse_options);

        Cursor cursor = storage.getKlasser();
        KlasseAdapter adapter = new KlasseAdapter(this, cursor, 0);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(KlasseActivity.this, UgeListeActivity.class);
                //intent.putExtra(Note.REJSE_ID, (int) id);
                startActivity(intent);
            }
        });

        listView.setAdapter(adapter);

        //TODO: Indsætte en fab
       /* FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab_opretNote);
        fab1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(KlasseActivity.this, MainActivity.class);
                intent.putExtra("Rejse_id", id);
                startActivity(intent);
            }
        });*/


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
