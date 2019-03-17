package com.example.sa_hw;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.sa_hw.domain.Course;
import com.example.sa_hw.usecase.ReadUseCase;

public class MyCursorAdapter extends CursorAdapter {

    public MyCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

//    static class ViewHolder{
//        public TextView tx_id;
//        public TextView tx_name;
//        public TextView tx_intorduction;
//        public TextView tx_suitable;
//        public TextView tx_price;
//        public TextView tx_notice;
//        public TextView tx_remark;
//    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
//        ViewHolder viewHolder = new ViewHolder();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_list_view,parent,false);

        ReadUseCase readUseCase = new ReadUseCase(view,inflater,null);
        View readOutput = readUseCase.ReadData();
        Log. i("cursor" ,"newView=" +view);

        return readOutput;

//        Course txCourse = new Course();
//        txCourse.setTxId((TextView)view.findViewById(R.id.dataId));
//        txCourse.setTxName((TextView)view.findViewById(R.id.dataName));
//        txCourse.setTxIntroduction((TextView)view.findViewById(R.id.dataIntro));
//        txCourse.setTxSuitable((TextView)view.findViewById(R.id.dataSuitable));
//        txCourse.setTxPrice((TextView)view.findViewById(R.id.dataPrice));
//        txCourse.setTxNotice((TextView)view.findViewById(R.id.dataNotice));
//        txCourse.setTxRemark((TextView)view.findViewById(R.id.dataRemark));
//
//        view.setTag(txCourse);
//        Log. i("cursor" ,"newView=" +view);
//        return view;

//        return LayoutInflater.from(context).inflate(R.layout.activity_list_view, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        Log. i("cursor" ,"bindView=" +view);

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

//        TextView dataId = view.findViewById(R.id.dataId);
//        TextView dataName = view.findViewById(R.id.dataName);
//        TextView dataIntro = view.findViewById(R.id.dataIntro);
//        TextView dataSuitable = view.findViewById(R.id.dataSuitable);
//        TextView dataPrice = view.findViewById(R.id.dataPrice);
//        TextView dataNotice = view.findViewById(R.id.dataNotice);
//        TextView dataRemark = view.findViewById(R.id.dataRemark);
//
//        int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
//        String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
//        String introduction = cursor.getString(cursor.getColumnIndexOrThrow("introduction"));
//        String suitable = cursor.getString(cursor.getColumnIndexOrThrow("suitable"));
//        String price = cursor.getString(cursor.getColumnIndexOrThrow("price"));
//        String notice = cursor.getString(cursor.getColumnIndexOrThrow("notice"));
//        String remark = cursor.getString(cursor.getColumnIndexOrThrow("remark"));
//
//        dataId.setText("ID : "+Integer.toString(id));
//        dataName.setText("課程名稱 : " + name);
//        dataIntro.setText("課程說明 : " + introduction);
//        dataSuitable.setText("適合對象 : " + suitable);
//        dataPrice.setText("定價 : " + price);
//        dataNotice.setText("注意事項 : " + notice);
//        dataRemark.setText("備註 : " + remark);
    }
}