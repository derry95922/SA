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
        TextView Page2Id = view.findViewById(R.id.Page2Id);
        TextView Page2Title = view.findViewById(R.id.Page2Title);
        TextView Page2Subtitle = view.findViewById(R.id.Page2Subtitle);

        int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        String introduction = cursor.getString(cursor.getColumnIndexOrThrow("introduction"));

        Page2Id.setText(Integer.toString(id));
        Page2Title.setText(name);
        Page2Subtitle.setText(introduction);

//        final int position = cursor.getPosition();
//        CheckBox checkBox = view.findViewById(R.id.CheckBoxId);
//        checkBox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("click","click");
//                Log.d("position",Integer.toString(position));
//            }
//        });
    }

//    public int getPosition(){
//        return position;
//    }
}