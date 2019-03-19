package com.example.sa_hw.DAO;

import android.content.ContentValues;
import com.example.sa_hw.domain.Course;

import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEINTRO;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSENAME;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSENOTICE;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEPRICE;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEREMARK;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSESUITABLE;

public class SQLiteAccess implements DAO{
    @Override
    public ContentValues create(Course course) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_COURSENAME, course.getCourseName());
        values.put(COLUMN_NAME_COURSEINTRO, course.getCourseIntroduction());
        values.put(COLUMN_NAME_COURSESUITABLE, course.getCourseSuitable());
        values.put(COLUMN_NAME_COURSEPRICE, course.getCoursePrice());
        values.put(COLUMN_NAME_COURSENOTICE, course.getCourseNotice());
        values.put(COLUMN_NAME_COURSEREMARK, course.getCourseRemark());
        return values;
    }

    @Override
    public ContentValues update(Course course) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_COURSENAME, course.getCourseName());
        values.put(COLUMN_NAME_COURSEINTRO, course.getCourseIntroduction());
        values.put(COLUMN_NAME_COURSESUITABLE, course.getCourseSuitable());
        values.put(COLUMN_NAME_COURSEPRICE, course.getCoursePrice());
        values.put(COLUMN_NAME_COURSENOTICE, course.getCourseNotice());
        values.put(COLUMN_NAME_COURSEREMARK, course.getCourseRemark());
        return values;
    }
}
