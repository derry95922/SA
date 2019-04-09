package com.example.sa_hw.HW2Adapter.Presenter;

import com.example.sa_hw.HW2UseCase.CreateCourse.CreateCourseOutput;

public class CreateCoursePresenter {

    public CreateCoursePresenter(){}

    private String courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
