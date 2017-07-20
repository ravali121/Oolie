package com.example.student.oolie.data;

import com.example.student.oolie.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Student on 7/13/17.
 */

public class DataSource  implements DataSourceInterface{
    int TYPE_IMAGE = 1;
    int TYPE_VIDEO = 2;

    private static final int sizeOfCollection = 8;

    private final String[] datesAndTimes ={
             "Wed Jul 12 2017",
             "Thu Jul 13 2017",
             "Fri Jul 14 2017",
             "Sat Jul 15 2017",
             "Sun Jul 16 2017"

    };
    private final String[] comments = {
            "Hey How are you doing today?",
            "What are your weekend plans",
            "Get the party started",
            "Where are we going for the trip",
            "How is your preparation for the finals"
    };
    private final int[] schoolLogos={
            R.mipmap.school,
            R.mipmap.school,
            R.mipmap.school,
            R.mipmap.school

    };

    private final String[] schoolNames={
            "Evergreen Valley High School",
            "Montogomery School",
            "Challenger",
            "San Jose State University"
    };


    public DataSource() {
    }


    @Override
    public List<ListItem> getListOfData() {

        ArrayList<ListItem> listOfData = new ArrayList<>();

        Random random = new Random();
        for(int i=0;i<8;i++){
            int randOne = random.nextInt(4);
            int randTwo = random.nextInt(4);
            int randThree = random.nextInt(4);
            int randFour = random.nextInt(4);

            ListItem listItem = new ListItem(datesAndTimes[randOne],comments[randTwo],schoolNames[randThree],schoolLogos[randFour],TYPE_IMAGE);
            listOfData.add(listItem);

        }
        return listOfData;
    }
}
