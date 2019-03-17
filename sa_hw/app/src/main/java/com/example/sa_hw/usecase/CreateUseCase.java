package com.example.sa_hw.usecase;

import android.content.ContentValues;

import com.example.sa_hw.domain.Course;

public class CreateUseCase {
    public CreateUseCase(){}

    public ContentValues createData(String name, String introduction, String suitable, String price, String notice, String remark){

        Course course = new Course();
        course.setCourse(name, introduction, suitable, price, notice, remark);
        return course.getCourse();

    }












}
