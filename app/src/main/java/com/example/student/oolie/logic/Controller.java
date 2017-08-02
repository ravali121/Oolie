package com.example.student.oolie.logic;

import com.example.student.oolie.data.DataSourceInterface;
import com.example.student.oolie.data.ListItem;
import com.example.student.oolie.view.ViewInterface;

/**
 * Created by Student on 7/13/17.
 */

public class Controller {

    private ViewInterface view;
    private DataSourceInterface dataSource;

    public Controller(ViewInterface view, DataSourceInterface dataSource) {
        this.view = view;
        this.dataSource = dataSource;
        getListFromDataSource();
    }

    public void getListFromDataSource() {
        view.setUpAdapterAndView(dataSource.getListOfData());
    }

    public void onListItemClick(ListItem testItem) {
        //view.startDetailActivity(testItem.getDateAndTime(),testItem.getPosts(),testItem.getSchoolName(),testItem.getSchoolLogo());

    }

}
