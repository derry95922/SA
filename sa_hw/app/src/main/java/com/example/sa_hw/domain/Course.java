package com.example.sa_hw.domain;

import android.content.ContentValues;
import android.widget.TextView;

import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEINTRO;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSENAME;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSENOTICE;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEPRICE;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSEREMARK;
import static com.example.sa_hw.FeedReaderContract.FeedEntry.COLUMN_NAME_COURSESUITABLE;

public class Course {
    public Course(){}

    private String courseName;
    private String courseIntroduction;
    private String courseSuitable;
    private String coursePrice;
    private String courseNotice;
    private String courseRemark;

    private TextView txId;
    private TextView txName;
    private TextView txIntroduction;
    private TextView txSuitable;
    private TextView txPrice;
    private TextView txNotice;
    private TextView txRemark;


    public TextView getTxId() {
        return txId;
    }

    public void setTxId(TextView txId) {
        this.txId = txId;
    }

    public TextView getTxName() {
        return txName;
    }

    public void setTxName(TextView txName) {
        this.txName = txName;
    }

    public TextView getTxIntroduction() {
        return txIntroduction;
    }

    public void setTxIntroduction(TextView txIntroduction) {
        this.txIntroduction = txIntroduction;
    }

    public TextView getTxSuitable() {
        return txSuitable;
    }

    public void setTxSuitable(TextView txSuitable) {
        this.txSuitable = txSuitable;
    }

    public TextView getTxPrice() {
        return txPrice;
    }

    public void setTxPrice(TextView txPrice) {
        this.txPrice = txPrice;
    }

    public TextView getTxNotice() {
        return txNotice;
    }

    public void setTxNotice(TextView txNotice) {
        this.txNotice = txNotice;
    }

    public TextView getTxRemark() {
        return txRemark;
    }

    public void setTxRemark(TextView txRemark) {
        this.txRemark = txRemark;
    }

    private String getCourseName() {
        return courseName;
    }

    private void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    private String getCourseIntroduction() {
        return courseIntroduction;
    }

    private void setCourseIntroduction(String courseIntroduction) {
        this.courseIntroduction = courseIntroduction;
    }

    private String getCourseSuitable() {
        return courseSuitable;
    }

    private void setCourseSuitable(String courseSuitable) {
        this.courseSuitable = courseSuitable;
    }

    private String getCoursePrice() {
        return coursePrice;
    }

    private void setCoursePrice(String coursePrice) {
        this.coursePrice = coursePrice;
    }

    private String getCourseNotice() {
        return courseNotice;
    }

    private void setCourseNotice(String courseNotice) {
        this.courseNotice = courseNotice;
    }

    private String getCourseRemark() {
        return courseRemark;
    }

    private void setCourseRemark(String courseRemark) {
        this.courseRemark = courseRemark;
    }

    public void setCourse(String name, String introduction, String suitable, String price, String notice, String remark){
        setCourseName(name);
        setCourseIntroduction(introduction);
        setCourseSuitable(suitable);
        setCoursePrice(price);
        setCourseNotice(notice);
        setCourseRemark(remark);
    }

    public ContentValues getCourse(){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME_COURSENAME, getCourseName());
        values.put(COLUMN_NAME_COURSEINTRO, getCourseIntroduction());
        values.put(COLUMN_NAME_COURSESUITABLE, getCourseSuitable());
        values.put(COLUMN_NAME_COURSEPRICE, getCoursePrice());
        values.put(COLUMN_NAME_COURSENOTICE, getCourseNotice());
        values.put(COLUMN_NAME_COURSEREMARK, getCourseRemark());
        return values;
    }

    public void setTxCourse(TextView txId, TextView txName, TextView txIntroduction, TextView txSuitable, TextView txPrice, TextView txNotice, TextView txRemark){
        setTxId(txId);
        setTxName(txName);
        setTxIntroduction(txIntroduction);
        setTxSuitable(txSuitable);
        setTxPrice(txPrice);
        setTxNotice(txNotice);
        setTxRemark(txRemark);
    }

//    public TextView getTxCourse(TextView txId, TextView txName, TextView txIntroduction, TextView txSuitable, TextView txPrice, TextView txNotice, TextView txRemark){
//        Course txCourse = (Course) view.getTag();
//        getTxRemark();
//    }
}
