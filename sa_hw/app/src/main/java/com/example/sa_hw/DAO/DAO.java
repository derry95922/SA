package com.example.sa_hw.DAO;

import android.content.ContentValues;

import com.example.sa_hw.domain.Course;

public interface DAO {
    ContentValues create(Course course);
    ContentValues update(Course course);
}
