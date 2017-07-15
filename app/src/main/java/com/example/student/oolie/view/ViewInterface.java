package com.example.student.oolie.view;

import com.example.student.oolie.data.ListItem;

import java.util.List;

/**
 * Created by Student on 7/13/17.
 */

public interface ViewInterface  {
    void startDetailActivity(String dateAndTime, String comment, String schoolName, int schoolLogo );
    void setUpAdapterAndView(List<ListItem> listOfData );
}
