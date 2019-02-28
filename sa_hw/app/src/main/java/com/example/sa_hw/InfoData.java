package com.example.sa_hw;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEINTRO;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSENAME;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSENOTICE;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEPRICE;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEREMARK;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSESUITABLE;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.TABLE_NAME;

public class InfoData extends AppCompatActivity {

    private FeedReaderDbHelper dbHelper;
    private SQLiteDatabase db;
    private Button buttonFinishCreate;
    private EditText courseName;
    private EditText courseIntro;
    private EditText courseSuitable;
    private EditText coursePrice;
    private EditText courseNotice;
    private EditText courseRemark;
    private TextView text_view_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_data);
        dbHelper = new FeedReaderDbHelper(this);

        buttonFinishCreate = findViewById(R.id.buttonFinishCreate);
        buttonFinishCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createData();
                finish();
            }
        });
    }
    public void createData(){
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        courseName = findViewById(R.id.courseName);
        courseIntro = findViewById(R.id.courseIntro);
        courseSuitable = findViewById(R.id.courseSuitable);
        coursePrice = findViewById(R.id.coursePrice);
        courseNotice = findViewById(R.id.courseNotice);
        courseRemark = findViewById(R.id.courseRemark);

        String name = courseName.getText().toString().trim();
        String introduction = courseIntro.getText().toString().trim();
        String suitable = courseIntro.getText().toString().trim();
        String price = courseIntro.getText().toString().trim();
        String notice = courseIntro.getText().toString().trim();
        String remark = courseIntro.getText().toString().trim();

        values.put(COLUMN_NAME_COURSENAME, name);
        values.put(COLUMN_NAME_COURSEINTRO, introduction);
        values.put(COLUMN_NAME_COURSESUITABLE, suitable);
        values.put(COLUMN_NAME_COURSEPRICE, price);
        values.put(COLUMN_NAME_COURSENOTICE, notice);
        values.put(COLUMN_NAME_COURSEREMARK, remark);


        long newRowId = db.insert(TABLE_NAME, null, values);

//        text_view_id.setText(String.valueOf(newRowId));
        Log.d("ButtonCreate","here!!!");
    }

}
