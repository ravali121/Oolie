package com.example.student.oolie.view.People;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.student.oolie.R;
import com.example.student.oolie.view.Home.HomefeedActivity;
import com.example.student.oolie.view.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class PeopleActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    PeopleViewPagerAdapter peopleViewPagerAdapter;

    private static final int ACTIVITY_NUM = 2;
    private Context mContext = PeopleActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        peopleViewPagerAdapter = new PeopleViewPagerAdapter(getSupportFragmentManager());

        peopleViewPagerAdapter.addFragments(new PeopleFollowingFragment(),"Following");
        peopleViewPagerAdapter.addFragments(new PeopleFollowersFragment(),"Followers");

        viewPager.setAdapter(peopleViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        setupBottomNavigationView();
    }
    private void setupBottomNavigationView() {

        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.botNavView);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

}
