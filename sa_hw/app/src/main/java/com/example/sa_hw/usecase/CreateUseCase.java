package com.example.sa_hw.usecase;

import android.content.ContentValues;

import com.example.sa_hw.domain.Course;

public class CreateUseCase implements UseCase{
    public CreateUseCase(){}

    Course course;
    public void input(String name, String introduction, String suitable, int price, String notice, String remark){
        course = new Course();
        course.setCourse(name, introduction, suitable, price, notice, remark);
    }

    @Override
    public ContentValues output() {
        return course.getCourse();
    }
}
