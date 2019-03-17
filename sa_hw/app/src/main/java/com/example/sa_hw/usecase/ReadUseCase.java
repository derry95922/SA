package com.example.sa_hw.usecase;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.example.sa_hw.R;
import com.example.sa_hw.domain.Course;

public class ReadUseCase {

    LayoutInflater inflater;
    View view;
    Cursor cursor;
    public ReadUseCase(View view, LayoutInflater inflater, Cursor cursor){
        this.inflater = inflater;
        this.view = view;
        this.cursor = cursor;
    }

    public View ReadData(){
        Course txCourse = new Course();
        txCourse.setTxCourse(
                (TextView)view.findViewById(R.id.dataId),
                (TextView)view.findViewById(R.id.dataName),
                (TextView)view.findViewById(R.id.dataIntro),
                (TextView)view.findViewById(R.id.dataSuitable),
                (TextView)view.findViewById(R.id.dataPrice),
                (TextView)view.findViewById(R.id.dataNotice),
                (TextView)view.findViewById(R.id.dataRemark)
                );
        view.setTag(txCourse);
        return view;
    }
}
