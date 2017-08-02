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
    private final String[] posts = {
            "data:image/png;base64,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"
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
            int randTwo = random.nextInt(1);
            int randThree = random.nextInt(4);
            int randFour = random.nextInt(4);

            ListItem listItem = new ListItem(datesAndTimes[randOne],posts[randTwo],schoolNames[randThree],schoolLogos[randFour],TYPE_IMAGE);
            listOfData.add(listItem);

        }
        return listOfData;
    }
}
