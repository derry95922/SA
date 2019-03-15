package com.example.sa_hw.domain;

import android.content.ContentValues;

import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEINTRO;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSENAME;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSENOTICE;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEPRICE;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEREMARK;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSESUITABLE;

public class Course {
    public Course(){};

    private String _name;
    private String _introduction;
    private String _suitable;
    private String _price;
    private String _notice;
    private String _remark;

    public void setCourse(String name, String introduction, String suitable, String price, String notice, String remark){
        _name = name;
        _introduction = introduction;
        _suitable = suitable;
        _price = price;
        _notice = notice;
        _remark = remark;
    };

    public ContentValues getCourse(){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_COURSENAME, _name);
        values.put(COLUMN_NAME_COURSEINTRO, _introduction);
        values.put(COLUMN_NAME_COURSESUITABLE, _suitable);
        values.put(COLUMN_NAME_COURSEPRICE, _price);
        values.put(COLUMN_NAME_COURSENOTICE, _notice);
        values.put(COLUMN_NAME_COURSEREMARK, _remark);
        return values;
    };
}
