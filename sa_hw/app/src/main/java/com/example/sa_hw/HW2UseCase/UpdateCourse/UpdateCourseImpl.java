package com.example.sa_hw.HW2UseCase.UpdateCourse;

import com.example.sa_hw.HW2Domain.HW2Course;
import com.example.sa_hw.HW2UseCase.CourseRepository;

public class UpdateCourseImpl implements UpdateCourse{

    private String courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    private CourseRepository courseRepository;

    public UpdateCourseImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public void execute(UpdateCourseInput input, UpdateCourseOutput output) {
        HW2Course hw2Course = new HW2Course(input.getCourseName(),
                                            input.getCourseIntroduction(),
                                            input.getCourseSuitable(),
                                            input.getCoursePrice(),
                                            input.getCourseNotice(),
                                            input.getCourseRemark());
        output.setNewCourseName(input.getCourseName());
        courseRepository.update(input.getCourseName(),hw2Course);
    }
}
