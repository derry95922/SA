package com.example.sa_hw;

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
import android.widget.Toast;

import static android.provider.BaseColumns._ID;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.TABLE_NAME;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener{

    private Button buttonRead;
    private Button buttonDelete;
    private Button buttonUpdate;
    private Button buttonCreate;
    private ListView list_view_id_data;
    private FeedReaderDbHelper dbHelper;
    private SQLiteDatabase db;
    private EditText editTextId;
    private Cursor saveCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new FeedReaderDbHelper(this);
        editTextId = findViewById(R.id.editTextId);

        buttonCreate = findViewById(R.id.buttonCreate);
        buttonCreate.setOnClickListener(this);

        buttonRead = findViewById(R.id.buttonRead);
        buttonRead.setOnClickListener(this);

        buttonDelete = findViewById(R.id.buttonDelete);
        buttonDelete.setOnClickListener(this);

        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonUpdate.setOnClickListener(this);

        list_view_id_data = findViewById(R.id.list_view_id_data);
        list_view_id_data.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonCreate){
            Intent createData = new Intent(this, FillDataActivity.class);
            startActivity(createData);
        }else if(v.getId()==R.id.buttonRead){
            db = dbHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
            MyCursorAdapter myCursorAdapter = new MyCursorAdapter(this, cursor);
            list_view_id_data.setAdapter(myCursorAdapter);
        }else if(v.getId()==R.id.buttonDelete){
            String id = editTextId.getText().toString().trim();
            if("".equals(id)){
                Toast.makeText(MainActivity.this," 請選擇要刪除的課程 ID ! ", Toast.LENGTH_LONG).show();
            }else {
                deleteData(id);
            }
            readData();
        }else if(v.getId()==R.id.buttonUpdate){
            String id = editTextId.getText().toString().trim();
            if("".equals(id)){
                Toast.makeText(MainActivity.this," 請選擇要修改的課程 ID ! ", Toast.LENGTH_LONG).show();
            }else{
                Intent updateData = new Intent(getApplicationContext(), FillDataActivity.class);
                setData(updateData);
                startActivity(updateData);
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> list_view_id_data, View view, int position, long id) {
        saveCursor = (Cursor) list_view_id_data.getItemAtPosition(position);
        Log.d("click",saveCursor.getString(0));
        Toast.makeText(MainActivity.this,"你選擇 " + " ID : " + saveCursor.getString(0) + " , "+ saveCursor.getString(1), Toast.LENGTH_LONG).show();
        editTextId.setText(saveCursor.getString(0));
    }

    public void setData(Intent intent) {
        String id = saveCursor.getString(saveCursor.getColumnIndexOrThrow("_id"));
        String courseName = saveCursor.getString(saveCursor.getColumnIndexOrThrow("name"));
        String introduction = saveCursor.getString(saveCursor.getColumnIndexOrThrow("introduction"));
        String suitable = saveCursor.getString(saveCursor.getColumnIndexOrThrow("suitable"));
        String price = saveCursor.getString(saveCursor.getColumnIndexOrThrow("price"));
        String notice = saveCursor.getString(saveCursor.getColumnIndexOrThrow("notice"));
        String remark = saveCursor.getString(saveCursor.getColumnIndexOrThrow("remark"));

        intent.putExtra("_id", id);
        intent.putExtra("courseName",courseName);
        intent.putExtra("introduction",introduction);
        intent.putExtra("suitable",suitable);
        intent.putExtra("price",price);
        intent.putExtra("notice",notice);
        intent.putExtra("remark",remark);
    }

    public void readData(){
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        MyCursorAdapter myCursorAdapter = new MyCursorAdapter(this, cursor);
        list_view_id_data.setAdapter(myCursorAdapter);
    }

    public void deleteData(String id){
        String selection = _ID + " = ?";
        String[] selectionArgs = { id };

//        DeleteUseCase deleteUseCase = DeleteUseCase();
//        String selection = deleteUseCase.

        int deletedRow = db.delete(TABLE_NAME, selection, selectionArgs);
        Log.d("deleteButton",Integer.toString(deletedRow));
    }
}