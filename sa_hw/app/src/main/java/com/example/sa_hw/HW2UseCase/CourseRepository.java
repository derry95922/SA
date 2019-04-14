package com.example.sa_hw.HW2UseCase;

import com.example.sa_hw.HW2Domain.HW2Course;

public interface CourseRepository {
    void create(HW2Course course);
    void update(String id, HW2Course course);
    void delete(String id);
}
