package com.example.sa_hw.usecase;

import android.content.ContentValues;

import com.example.sa_hw.DAO.DAO;
import com.example.sa_hw.DAO.SQLiteAccess;
import com.example.sa_hw.domain.Course;

public class UpdateUseCase implements UseCase{
    public UpdateUseCase(){}

    Course course;
    public void input(String name, String introduction, String suitable, int price, String notice, String remark){
        course = new Course();
        course.setCourse(name, introduction, suitable, price, notice, remark);
    }

    public ContentValues updateData(){
        DAO dao = new SQLiteAccess();
        ContentValues result = dao.update(course);
        return result;
    }
}
