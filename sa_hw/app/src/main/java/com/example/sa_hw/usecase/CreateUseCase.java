package com.example.sa_hw.usecase;

import android.content.ContentValues;

import com.example.sa_hw.domain.Course;

import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEINTRO;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSENAME;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSENOTICE;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEPRICE;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEREMARK;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSESUITABLE;

public class CreateUseCase {
    public CreateUseCase(){};

    public ContentValues createData(String name, String introduction, String suitable, String price, String notice, String remark){

        Course course = new Course();
        course.setCourse(name, introduction, suitable, price, notice, remark);
        ContentValues values = course.getCourse();

        return values;
    }
}
