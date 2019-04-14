package com.example.sa_hw.HW2UseCase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.sa_hw.FeedReaderDbHelper;
import com.example.sa_hw.FillDataActivity;
import com.example.sa_hw.HW2Adapter.Controller.CourseDTO;
import com.example.sa_hw.HW2Domain.HW2Course;
import com.example.sa_hw.HW2UseCase.CourseRepository;

import static android.provider.BaseColumns._ID;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.TABLE_NAME;

public class CourseRepositoryImpl implements CourseRepository {
    private SQLiteDatabase db;
    private FeedReaderDbHelper dbHelper;
    private Context context;

    public CourseRepositoryImpl(Context context){
        this.context = context;
        dbHelper = new FeedReaderDbHelper(context);//context
        db = dbHelper.getWritableDatabase();
    }

    @Override
    public void create(HW2Course course) {

        CourseDTO dto = new CourseDTO(course.getCourseName(),
                                        course.getCourseIntroduction(),
                                        course.getCourseSuitable(),
                                        course.getCoursePrice(),
                                        course.getCourseNotice(),
                                        course.getCourseRemark());

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", dto.getCourseName());
        contentValues.put("introduction", dto.getCourseIntroduction());
        contentValues.put("suitable", dto.getCourseSuitable());
        contentValues.put("price", dto.getCoursePrice());
        contentValues.put("notice", dto.getCourseNotice());
        contentValues.put("remark", dto.getCourseRemark());

        db.insert(TABLE_NAME, null, contentValues);
    }

    @Override
    public void update(String id, HW2Course course) {

        CourseDTO dto = new CourseDTO(course.getCourseName(),
                course.getCourseIntroduction(),
                course.getCourseSuitable(),
                course.getCoursePrice(),
                course.getCourseNotice(),
                course.getCourseRemark());

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", dto.getCourseName());
        contentValues.put("introduction", dto.getCourseIntroduction());
        contentValues.put("suitable", dto.getCourseSuitable());
        contentValues.put("price", dto.getCoursePrice());
        contentValues.put("notice", dto.getCourseNotice());
        contentValues.put("remark", dto.getCourseRemark());

        String selection = _ID + " = ?";
        String[] selectionArgs = { id };

        db.update(
                TABLE_NAME,
                contentValues,
                selection,
                selectionArgs);
    }

    @Override
    public void delete(String id) {

        String selection = _ID + " = ?";
        String[] selectionArgs = { id };

        db.delete(TABLE_NAME, selection, selectionArgs);
    }
}
