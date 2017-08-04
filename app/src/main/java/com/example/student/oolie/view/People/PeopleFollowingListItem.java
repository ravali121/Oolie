package com.example.student.oolie.view.People;

/**
 * Created by Student on 8/4/17.
 */

public class PeopleFollowingListItem {

    private String username;
    private String gradLevel;
    private String schoolName;

    public PeopleFollowingListItem(String username, String gradLevel, String schoolName) {
        this.username = username;
        this.gradLevel = gradLevel;
        this.schoolName = schoolName;
    }

    public String getUsername() {
        return username;
    }

    public String getGradLevel() {
        return gradLevel;
    }

    public String getSchoolName() {
        return schoolName;
    }
}
