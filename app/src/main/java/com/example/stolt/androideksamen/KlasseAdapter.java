package com.example.stolt.androideksamen;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class KlasseAdapter extends CursorAdapter {

    private Storage storage;
    private LayoutInflater cursorInflater;
    private View.OnClickListener listener;

    public KlasseAdapter(Context context, Cursor cursor, int flags ) {
        super(context, cursor, flags);
        cursorInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.listener = listener;
        storage = Storage.getInstance();
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return cursorInflater.inflate(R.layout.activity_klasse_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        KlasseWrapper wrapper = (KlasseWrapper) cursor;
        Klasse klasse = wrapper.getKlasse();

        TextView KlasseNavn = (TextView) view.findViewById(R.id.item_klasseNavn);
        KlasseNavn.setText(klasse.getKlasseNavn());

        TextView KlasseSemester = (TextView) view.findViewById(R.id.item_klasseSemester);
        KlasseSemester.setText(""+klasse.getSemester());
    }
}
