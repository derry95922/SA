package com.example.sa_hw;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

//import static android.provider.BaseColumns._ID;
//import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE;
//import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE;
//import static com.example.sa_hw.FeedReaderContract.FeedEntry.TABLE_NAME;

public class MainActivity extends AppCompatActivity {

    private Button button_insert;
    private Button button_read;
    private Button button_delete;
    private Button button_update;
    private TextView text_view_id;
    private TextView text_view_id_data;
    private ListView list_view_id_data;
    private FeedReaderDbHelper dbHelper;
    private SQLiteDatabase db;
    private EditText editTextTitle;
    private EditText editTextSubtitle;
    private EditText editTextId;
    private MyCursorAdapter myCursorAdapter;
    //------------------------------------------------------
    private Button buttonCreate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new FeedReaderDbHelper(this);

        text_view_id = findViewById(R.id.text_view_id);
        text_view_id_data = findViewById(R.id.text_view_id_data);
        button_insert = findViewById(R.id.button_insert);

        /*button_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createData();
            }
        });

        button_read = findViewById(R.id.button_read);
        list_view_id_data = findViewById(R.id.list_view_id_data);
        button_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readData();
            }
        });

        list_view_id_data = findViewById(R.id.list_view_id_data);
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        myCursorAdapter = new MyCursorAdapter(this,cursor);
        list_view_id_data.setAdapter(myCursorAdapter);
        list_view_id_data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> list_view_id_data, View view, int position, long id) {
                Cursor cursor = (Cursor) list_view_id_data.getItemAtPosition(position);
                Log.d("click",cursor.getString(1));
                Log.d("click",cursor.getString(2));
                Log.d("click",Integer.toString(position));
            }
        });

        button_delete = findViewById(R.id.button_delete);
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextId = findViewById(R.id.editTextId);
                String id = editTextId.getText().toString().trim();
                deleteData(id);
            }
        });

        button_update = findViewById(R.id.button_update);
        button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextId = findViewById(R.id.editTextId);
                String id = editTextId.getText().toString().trim();
                updateData(id);
            }
        });*/

        //------------------------------------------------------
        buttonCreate = findViewById(R.id.buttonCreate);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityInfoData();
            }
        });

    }
/*
    public void createData(){
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextSubtitle = findViewById(R.id.editTextSubtitle);
        String title = editTextTitle.getText().toString().trim();
        String subtitle = editTextSubtitle.getText().toString().trim();
        values.put(COLUMN_NAME_TITLE, title);
        values.put(COLUMN_NAME_SUBTITLE, subtitle);

        long newRowId = db.insert(TABLE_NAME, null, values);

        text_view_id.setText(String.valueOf(newRowId));
        Log.d("ButtonCreate","here!!!");
    }

    public void readData(){
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        cursor.moveToFirst();
        int rows_num = cursor.getCount();
        for(int i=0;i<rows_num;i++){
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            String subtitle = cursor.getString(2);
            Log.d("content","id: "+id+" title: "+title+" subtitle: "+subtitle);
            cursor.moveToNext();
        }
        text_view_id_data.setMovementMethod(new ScrollingMovementMethod());

        ListView list_view_id_data = (ListView) findViewById(R.id.list_view_id_data);
        MyCursorAdapter myAdapter = new MyCursorAdapter(this, cursor);
        list_view_id_data.setAdapter(myAdapter);
    }

    public void deleteData(String id){
        String selection = _ID + " = ?";
        String[] selectionArgs = { id };
        int deletedRow = db.delete(TABLE_NAME, selection, selectionArgs);
        text_view_id.setText(id);
    }

    public void deleteDataByRadioButton(int position){
        String selection = _ID + " = ?";

        String[] selectionArgs = { Integer.toString(position) };
        int deletedRow = db.delete(TABLE_NAME, selection, selectionArgs);
        text_view_id.setText(String.valueOf(position));
    }

    public void updateData(String id){
        db = dbHelper.getWritableDatabase();

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextSubtitle = findViewById(R.id.editTextSubtitle);
        String title = editTextTitle.getText().toString().trim();
        String subtitle = editTextSubtitle.getText().toString().trim();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_TITLE, title);
        values.put(COLUMN_NAME_SUBTITLE,subtitle);

        String selection = _ID + " = ?";
        String[] selectionArgs = { id };

        int count = db.update(
                TABLE_NAME,
                values,
                selection,
                selectionArgs);

        text_view_id.setText(id);
    }*/

    //-------------------------------------------------------------
    public void openActivityInfoData(){
        Intent intent = new Intent(this, InfoData.class);
        startActivity(intent);
    }
}