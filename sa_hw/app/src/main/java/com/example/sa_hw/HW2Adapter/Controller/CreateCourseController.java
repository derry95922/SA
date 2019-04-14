package com.example.sa_hw.HW2Adapter.Controller;

import android.content.Context;

import com.example.sa_hw.HW2UseCase.CourseRepositoryImpl;
import com.example.sa_hw.HW2UseCase.CourseRepository;
import com.example.sa_hw.HW2UseCase.CreateCourse.CreateCourse;
import com.example.sa_hw.HW2UseCase.CreateCourse.CreateCourseImpl;
import com.example.sa_hw.HW2UseCase.CreateCourse.CreateCourseInputImpl;

public class CreateCourseController {
    private Context context;

    public CreateCourseController(Context context){
        this.context = context;
    }

    CourseRepository courseRepository = new CourseRepositoryImpl(context);
    public CreateCourse createCourse = new CreateCourseImpl(courseRepository);
//    public CreateCourseOutputImpl createCoursePresenter = new CreateCoursePresenter();


    public CreateCourseController(String name, String introduction, String suitable, int price, String notice, String remark){
        createCourseExecute(name, introduction, suitable, price, notice, remark);
    }

    public void createCourseExecute(String name, String introduction, String suitable, int price, String notice, String remark){
        CreateCourseInputImpl input = (CreateCourseInputImpl) createCourse;
        input.setCourseName(name);
        input.setCourseIntroduction(introduction);
        input.setCourseSuitable(suitable);
        input.setCoursePrice(price);
        input.setCourseNotice(notice);
        input.setCourseRemark(remark);

//        CreateCourseOutputImpl output = createCoursePresenter;

//        createCourse.execute(input,output);
    }
}