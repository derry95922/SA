package com.example.sa_hw;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class MyCursorAdapter extends CursorAdapter {

    public MyCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.activity_page2, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView dataId = view.findViewById(R.id.dataId);
        TextView dataName = view.findViewById(R.id.dataName);
        TextView dataIntro = view.findViewById(R.id.dataIntro);

        int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        String introduction = cursor.getString(cursor.getColumnIndexOrThrow("introduction"));

        dataId.setText(Integer.toString(id));
        dataName.setText(name);
        dataIntro.setText(introduction);
    }
}