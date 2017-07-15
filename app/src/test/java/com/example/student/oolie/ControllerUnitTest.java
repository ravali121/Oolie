package com.example.student.oolie;

import com.example.student.oolie.data.DataSourceInterface;
import com.example.student.oolie.data.ListItem;
import com.example.student.oolie.logic.Controller;
import com.example.student.oolie.view.ViewInterface;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ControllerUnitTest {

    @Mock
    ViewInterface view;
    @Mock
    DataSourceInterface dataSource;

    Controller controller;


    private static final ListItem testItem = new
            ListItem("Wed Jul 12 2017",
            "Hey How are you doing today?",
            "Evergreen Valley High School",
            R.mipmap.school);

    @Before
    public void setUpTest(){
        MockitoAnnotations.initMocks(this);

        controller= new Controller(view,dataSource);

    }
    @Test
    public void onGetDataSuccess() throws Exception {
        ArrayList<ListItem> listOfData = new ArrayList<>();
        listOfData.add(testItem);
        //Set mocks ot return the data we want
        Mockito.when(dataSource.getListOfData()).thenReturn(listOfData);
        //Call the method/Unit we are testing
        controller.getListFromDataSource();
        //Behaviour test
        Mockito.verify(view).setUpAdapterAndView(listOfData);
    }
    @Test
    public void onListItemClicked(){

        controller.onListItemClick(testItem);
        Mockito.verify(view).startDetailActivity(testItem.getDateAndTime(),testItem.getComment(),testItem.getSchoolName(),testItem.getSchoolLogo());
    }
}