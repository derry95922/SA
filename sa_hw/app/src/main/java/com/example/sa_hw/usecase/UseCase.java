package com.example.sa_hw.usecase;

import android.content.ContentValues;

public interface UseCase {
    void input(String name, String introduction, String suitable, int price, String notice, String remark);
    ContentValues output();
}
