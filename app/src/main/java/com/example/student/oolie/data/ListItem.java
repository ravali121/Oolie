package com.example.student.oolie.data;

/**
 * Created by Student on 7/13/17.
 */

public class ListItem {
    private String dateAndTime;
    private String comment;
    private String schoolName;
    private int schoolLogo;

    public ListItem(String dateAndTime, String comment, String schoolName, int schoolLogo) {
        this.dateAndTime = dateAndTime;
        this.comment = comment;
        this.schoolName = schoolName;
        this.schoolLogo = schoolLogo;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getSchoolLogo() {
        return schoolLogo;
    }

    public void setSchoolLogo(int schoolLogo) {
        this.schoolLogo = schoolLogo;
    }
}