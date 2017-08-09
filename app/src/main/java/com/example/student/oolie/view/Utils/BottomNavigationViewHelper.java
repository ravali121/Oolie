package com.example.student.oolie.view.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.example.student.oolie.R;
import com.example.student.oolie.view.Camera.CameraActivity;
import com.example.student.oolie.view.Home.HomefeedActivity;
import com.example.student.oolie.view.More.MoreActivity;
import com.example.student.oolie.view.People.PeopleActivity;
import com.example.student.oolie.view.SchoolBoard.SchoolBoardActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import static android.content.ContentValues.TAG;

/**
 * Created by Student on 8/3/17.
 */

public class BottomNavigationViewHelper {
    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        Log.d(TAG, "setupBottomNavigationView: Setting up BottomNavigationView");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }
    public static void enableNavigation(final Context context, BottomNavigationViewEx view) {
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.ic_home:
                        Intent home = new Intent(context, HomefeedActivity.class);//ACTIVITY_NUM = 0
                        home.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        context.startActivity(home);

                        break;

                    case R.id.ic_camera:
                        Intent camera = new Intent(context, CameraActivity.class);//ACTIVITY_NUM = 1
                        camera.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        context.startActivity(camera);
                        break;

                    case R.id.ic_people:
                        Intent people = new Intent(context, PeopleActivity.class);//ACTIVITY_NUM = 2
                        people.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        context.startActivity(people);
                        break;

                    case R.id.ic_school_board:
                        Intent schoolBoard = new Intent(context, SchoolBoardActivity.class);//ACTIVITY_NUM = 3
                        schoolBoard.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        context.startActivity(schoolBoard);
                        break;

                    case R.id.ic_more:
                        Intent more = new Intent(context, MoreActivity.class);//ACTIVITY_NUM = 4
                        more.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        context.startActivity(more);
                        break;
                }


                return false;
            }
        });
    }
}
