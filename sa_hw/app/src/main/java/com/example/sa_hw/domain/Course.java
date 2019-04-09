package com.example.sa_hw.domain;

import android.widget.TextView;

public class Course {
    private String courseName;
    private String courseIntroduction;
    private String courseSuitable;
    private int coursePrice;
    private String courseNotice;
    private String courseRemark;

    private TextView txId;
    private TextView txName;
    private TextView txIntroduction;
    private TextView txSuitable;
    private TextView txPrice;
    private TextView txNotice;
    private TextView txRemark;

    public Course(){}

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

    public String getCourseName() {
        return courseName;
    }

    private void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseIntroduction() {
        return courseIntroduction;
    }

    private void setCourseIntroduction(String courseIntroduction) {
        this.courseIntroduction = courseIntroduction;
    }

    public String getCourseSuitable() {
        return courseSuitable;
    }

    private void setCourseSuitable(String courseSuitable) {
        this.courseSuitable = courseSuitable;
    }

    public int getCoursePrice() {
        return coursePrice;
    }

    private void setCoursePrice(int coursePrice) {
        this.coursePrice = coursePrice;
    }

    public String getCourseNotice() {
        return courseNotice;
    }

    private void setCourseNotice(String courseNotice) {
        this.courseNotice = courseNotice;
    }

    public String getCourseRemark() {
        return courseRemark;
    }

    private void setCourseRemark(String courseRemark) {
        this.courseRemark = courseRemark;
    }

    public void setCourse(String name, String introduction, String suitable, int price, String notice, String remark){
        setCourseName(name);
        setCourseIntroduction(introduction);
        setCourseSuitable(suitable);
        setCoursePrice(price);
        setCourseNotice(notice);
        setCourseRemark(remark);
    }

    public Course(String name, String introduction, String suitable, int price, String notice, String remark){
        setCourseName(name);
        setCourseIntroduction(introduction);
        setCourseSuitable(suitable);
        setCoursePrice(price);
        setCourseNotice(notice);
        setCourseRemark(remark);
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
