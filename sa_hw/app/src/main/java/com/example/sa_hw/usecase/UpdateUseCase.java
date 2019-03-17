package com.example.sa_hw.usecase;

import android.content.ContentValues;

import com.example.sa_hw.domain.Course;

public class UpdateUseCase {
    public UpdateUseCase(){}

    public ContentValues UpdateData(String name, String introduction, String suitable, String price, String notice, String remark){

        Course course = new Course();
        course.setCourse(name, introduction, suitable, price, notice, remark);
        return course.getCourse();

    }
}
