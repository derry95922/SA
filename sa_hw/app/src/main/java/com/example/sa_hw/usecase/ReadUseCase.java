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

    public void resultBindView(Cursor cursor){
        Course txCourse = (Course) view.getTag();

        int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        String introduction = cursor.getString(cursor.getColumnIndexOrThrow("introduction"));
        String suitable = cursor.getString(cursor.getColumnIndexOrThrow("suitable"));
        String price = cursor.getString(cursor.getColumnIndexOrThrow("price"));
        String notice = cursor.getString(cursor.getColumnIndexOrThrow("notice"));
        String remark = cursor.getString(cursor.getColumnIndexOrThrow("remark"));

        txCourse.getTxId().setText("ID : "+Integer.toString(id));
        txCourse.getTxName().setText("課程名稱 : " + name);
        txCourse.getTxIntroduction().setText("課程說明 : " + introduction);
        txCourse.getTxSuitable().setText("適合對象 : " + suitable);
        txCourse.getTxPrice().setText("定價 : " + price);
        txCourse.getTxNotice().setText("注意事項 : " + notice);
        txCourse.getTxRemark().setText("備註 : " + remark);
    }
}
