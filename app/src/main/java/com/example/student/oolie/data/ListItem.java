package com.example.student.oolie.data;

/**
 * Created by Student on 7/13/17.
 */

public class ListItem {
    private String dateAndTime;
    private String posts;
    private String schoolName;
    private int schoolLogo;
    private int type;

    public ListItem(String dateAndTime, String posts, String schoolName, int schoolLogo, int type) {
        this.dateAndTime = dateAndTime;
        this.posts = posts;
        this.schoolName = schoolName;
        this.schoolLogo = schoolLogo;
        this.type=type;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getPosts() {
        return posts;
    }

    public void setPosts(String posts) {
        this.posts = posts;
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

    public int getType(){
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
