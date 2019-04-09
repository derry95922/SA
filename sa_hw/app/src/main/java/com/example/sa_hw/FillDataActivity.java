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
import android.widget.Toast;

import com.example.sa_hw.HW2UseCase.CourseRepositoryImpl;
import com.example.sa_hw.HW2UseCase.CourseRepository;
import com.example.sa_hw.HW2UseCase.CreateCourse.CreateCourse;
import com.example.sa_hw.HW2UseCase.CreateCourse.CreateCourseImpl;
import com.example.sa_hw.HW2UseCase.CreateCourse.CreateCourseInput;
import com.example.sa_hw.HW2UseCase.CreateCourse.CreateCourseInputImpl;
import com.example.sa_hw.HW2UseCase.CreateCourse.CreateCourseOutputImpl;
import com.example.sa_hw.usecase.UpdateUseCase;

import static android.provider.BaseColumns._ID;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.TABLE_NAME;

public class FillDataActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonFinishUpdate;
    private Button buttonDiscardUpdate;
    private FeedReaderDbHelper dbHelper;
    private SQLiteDatabase db;
    private EditText courseName;
    private EditText courseIntro;
    private EditText courseSuitable;
    private EditText coursePrice;
    private EditText courseNotice;
    private EditText courseRemark;
    Intent updateData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_data);
        dbHelper = new FeedReaderDbHelper(this);

        updateData = getIntent();
        if(updateData.hasExtra("_id"))fillListViewText(updateData);

        buttonFinishUpdate = findViewById(R.id.buttonFinishUpdate);
        buttonFinishUpdate.setOnClickListener(this);

        buttonDiscardUpdate = findViewById(R.id.buttonDiscardUpdate);
        buttonDiscardUpdate.setOnClickListener(this);
    }

    public void fillListViewText(Intent updateData){
        String name = updateData.getStringExtra("courseName");
        String introduction = updateData.getStringExtra("introduction");
        String suitable = updateData.getStringExtra("suitable");
        String price = updateData.getStringExtra("price");
        String notice = updateData.getStringExtra("notice");
        String remark = updateData.getStringExtra("remark");
        Log.d("Data Here!!!!",courseName + "\n" +introduction+"\n"+suitable+"\n"+price+"\n"+notice+"\n"+remark);

        courseName = findViewById(R.id.courseName);
        courseIntro = findViewById(R.id.courseIntro);
        courseSuitable = findViewById(R.id.courseSuitable);
        coursePrice = findViewById(R.id.coursePrice);
        courseNotice = findViewById(R.id.courseNotice);
        courseRemark = findViewById(R.id.courseRemark);

        courseName.setText(name);
        courseIntro.setText(introduction);
        courseSuitable.setText(suitable);
        coursePrice.setText(price);
        courseNotice.setText(notice);
        courseRemark.setText(remark);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonFinishUpdate){
            if(updateData.hasExtra("_id")){
                courseName = findViewById(R.id.courseName);
                courseIntro = findViewById(R.id.courseIntro);
                courseSuitable = findViewById(R.id.courseSuitable);
                coursePrice = findViewById(R.id.coursePrice);
                courseNotice = findViewById(R.id.courseNotice);
                courseRemark = findViewById(R.id.courseRemark);

                String name = courseName.getText().toString().trim();
                String introduction = courseIntro.getText().toString().trim();
                String suitable = courseSuitable.getText().toString().trim();
                int price = Integer.parseInt(coursePrice.getText().toString().trim());
                String notice = courseNotice.getText().toString().trim();
                String remark = courseRemark.getText().toString().trim();

                UpdateUseCase updateUseCase = new UpdateUseCase();
                updateUseCase.input(name, introduction, suitable, price, notice, remark);
                ContentValues updateOutput = updateUseCase.updateData();

                db = dbHelper.getWritableDatabase();
                if ("".equals(name)){
                    Toast.makeText(FillDataActivity.this," 課程名稱不可為空白 ! ", Toast.LENGTH_LONG).show();
                }else{
                    String id = updateData.getStringExtra("_id");
                    String selection = _ID + " = ?";
                    String[] selectionArgs = { id };

                    db.update(
                            TABLE_NAME,
                            updateOutput,
                            selection,
                            selectionArgs);

                    finish();
                }
            }else{
//                courseName = findViewById(R.id.courseName);
//                courseIntro = findViewById(R.id.courseIntro);
//                courseSuitable = findViewById(R.id.courseSuitable);
//                coursePrice = findViewById(R.id.coursePrice);
//                courseNotice = findViewById(R.id.courseNotice);
//                courseRemark = findViewById(R.id.courseRemark);
//
//                String name = courseName.getText().toString().trim();
//                String introduction = courseIntro.getText().toString().trim();
//                String suitable = courseSuitable.getText().toString().trim();
//                int price = Integer.parseInt(coursePrice.getText().toString().trim());
//                String notice = courseNotice.getText().toString().trim();
//                String remark = courseRemark.getText().toString().trim();
//
//                CreateUseCase createUseCase = new CreateUseCase();
//                createUseCase.input(name, introduction, suitable, price, notice, remark);
//                ContentValues createOutput = createUseCase.createData();
//
//                db = dbHelper.getWritableDatabase();
//                if ("".equals(name)){
//                    Toast.makeText(FillDataActivity.this," 課程名稱不可為空白 ! ", Toast.LENGTH_LONG).show();
//                }else {
//                    db.insert(TABLE_NAME, null, createOutput);
//                    finish();
//                }
                courseName = findViewById(R.id.courseName);
                courseIntro = findViewById(R.id.courseIntro);
                courseSuitable = findViewById(R.id.courseSuitable);
                coursePrice = findViewById(R.id.coursePrice);
                courseNotice = findViewById(R.id.courseNotice);
                courseRemark = findViewById(R.id.courseRemark);

                String name = courseName.getText().toString().trim();
                String introduction = courseIntro.getText().toString().trim();
                String suitable = courseSuitable.getText().toString().trim();
                int price = Integer.parseInt(coursePrice.getText().toString().trim());
                String notice = courseNotice.getText().toString().trim();
                String remark = courseRemark.getText().toString().trim();

                CourseRepository repository = new CourseRepositoryImpl(this);
                CreateCourse createCourseUC = new CreateCourseImpl(repository);

                CreateCourseInput input = new CreateCourseInputImpl(name,introduction,suitable,price,notice,remark);
                CreateCourseOutputImpl output = new CreateCourseOutputImpl();

                createCourseUC.execute(input,output);

                finish();
            }
        }else {
            finish();
        }
    }
}