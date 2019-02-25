package com.example.sa_hw;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MyCursorAdapter extends CursorAdapter {

    public MyCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.activity_page2, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        RadioButton Page2RadioButton = (RadioButton) view.findViewById(R.id.Page2RadioButton);
        TextView Page2Title = (TextView) view.findViewById(R.id.Page2Title);
        TextView Page2Subtitle = (TextView) view.findViewById(R.id.Page2Subtitle);

        String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
        String subtitle = cursor.getString(cursor.getColumnIndexOrThrow("subtitle"));
//        int priority = cursor.getInt(cursor.getColumnIndexOrThrow(titleContext);
        Page2Title.setText(title);
        Page2Subtitle.setText(subtitle);
//        Page2Subtitle.setText(String.valueOf(priority));
    }
}