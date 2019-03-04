package com.example.sa_hw;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.BaseColumns._ID;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.TABLE_NAME;

public class MainActivity extends AppCompatActivity {

    private Button button_read;
    private Button button_delete;
    private Button button_update;
    private ListView list_view_id_data;
    private FeedReaderDbHelper dbHelper;
    private SQLiteDatabase db;
    private EditText editTextId;
    private MyCursorAdapter myAdapter;
    private MyCursorAdapter listViewCursorAdapter;
    private Button buttonCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new FeedReaderDbHelper(this);

        buttonCreate = findViewById(R.id.buttonCreate);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityInfoData();
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

        editTextId = findViewById(R.id.editTextId);
        list_view_id_data = findViewById(R.id.list_view_id_data);
        db = dbHelper.getReadableDatabase();
        final Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        listViewCursorAdapter = new MyCursorAdapter(this,cursor);
        list_view_id_data.setAdapter(listViewCursorAdapter);
        list_view_id_data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> list_view_id_data, View view, int position, long id) {
                Cursor cursor = (Cursor) list_view_id_data.getItemAtPosition(position);
//                Log.d("click",cursor.getString(1));
                Log.d("click",cursor.getString(0));
                Toast.makeText(MainActivity.this,"你選擇 " + " ID : " + cursor.getString(0) + " , "+ cursor.getString(1), Toast.LENGTH_LONG).show();
                editTextId.setText(cursor.getString(0));
                setData(cursor,position);
            }
        });

        button_delete = findViewById(R.id.button_delete);
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextId = findViewById(R.id.editTextId);
                String id = editTextId.getText().toString().trim();
                if("".equals(id)){
                    Toast.makeText(MainActivity.this," 請選擇要刪除的課程 ID ! ", Toast.LENGTH_LONG).show();
                }else {
                    deleteData(id);
                }
                readData();
            }
        });

        editTextId = findViewById(R.id.editTextId);
        button_update = findViewById(R.id.button_update);
        button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextId.getText().toString().trim();

                if("".equals(id)){
                    Toast.makeText(MainActivity.this," 請選擇要修改的課程 ID ! ", Toast.LENGTH_LONG).show();
                }else{
                    String courseName = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                    String introduction = cursor.getString(cursor.getColumnIndexOrThrow("introduction"));
                    String suitable = cursor.getString(cursor.getColumnIndexOrThrow("suitable"));
                    String price = cursor.getString(cursor.getColumnIndexOrThrow("price"));
                    String notice = cursor.getString(cursor.getColumnIndexOrThrow("notice"));
                    String remark = cursor.getString(cursor.getColumnIndexOrThrow("remark"));

                    Intent intent = new Intent(getApplicationContext(), updateData.class);
                    intent.putExtra("message", id);
                    intent.putExtra("courseName",courseName);
                    intent.putExtra("introduction",introduction);
                    intent.putExtra("suitable",suitable);
                    intent.putExtra("price",price);
                    intent.putExtra("notice",notice);
                    intent.putExtra("remark",remark);
                    startActivity(intent);
                }
            }
        });
    }

    public void openActivityInfoData(){
        Intent infoData = new Intent(this, InfoData.class);
        startActivity(infoData);
    }

    public void readData(){
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        cursor.moveToFirst();
        int rows_num = cursor.getCount();
        for(int i=0;i<rows_num;i++){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String intro = cursor.getString(2);
            Log.d("content","id: "+id+" title: "+name+" subtitle: "+intro);
            cursor.moveToNext();
        }
//        text_view_id_data.setMovementMethod(new ScrollingMovementMethod());

        list_view_id_data = findViewById(R.id.list_view_id_data);
        myAdapter = new MyCursorAdapter(this, cursor);
        list_view_id_data.setAdapter(myAdapter);
    }

    public void deleteData(String id){
        String selection = _ID + " = ?";
        String[] selectionArgs = { id };
        int deletedRow = db.delete(TABLE_NAME, selection, selectionArgs);
        Log.d("deleteButton",Integer.toString(deletedRow));
    }

    public void setData(Cursor cursor, int position){
        cursor = (Cursor) list_view_id_data.getItemAtPosition(position);
        String courseName = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        String introduction = cursor.getString(cursor.getColumnIndexOrThrow("introduction"));
        String suitable = cursor.getString(cursor.getColumnIndexOrThrow("suitable"));
        String price = cursor.getString(cursor.getColumnIndexOrThrow("price"));
        String notice = cursor.getString(cursor.getColumnIndexOrThrow("notice"));
        String remark = cursor.getString(cursor.getColumnIndexOrThrow("remark"));

        Intent intent = new Intent(getApplicationContext(), updateData.class);
        intent.putExtra("courseName",courseName);
        intent.putExtra("introduction",introduction);
        intent.putExtra("suitable",suitable);
        intent.putExtra("price",price);
        intent.putExtra("notice",notice);
        intent.putExtra("remark",remark);
    }
}