package com.example.student.oolie.data;

import java.util.List;

/**
 * Created by Student on 7/13/17.
 */

public interface DataSourceInterface {
    List<ListItem> getListOfData();
    /**
     * Any Class that implements this interface must have a method that returns a List of ListItems
     * and it must be called getListOfData().
     */
}
