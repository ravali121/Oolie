package com.example.student.oolie.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.student.oolie.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HomefeedActivity extends AppCompatActivity {


    private ViewPager viewPager;
    TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;
    ImageView profileImage;
    TextView fullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homefeed);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        loadImageFromStorage(preferences.getString("Bitmap"," "));
        fullname = (TextView)findViewById(R.id.tv_fullname);
                fullname.setText(preferences.getString("name"," "));


        // Set up the ViewPager with the sections adapter.
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new Tab1(), "Feed");
        viewPagerAdapter.addFragments(new Tab2(), "Photos/Videos");
        viewPagerAdapter.addFragments(new Tab3(), "Profile");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
    private void loadImageFromStorage(String path)
    {

        try {
            File f=new File(path, "profile.jpg");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
           profileImage=(ImageView)findViewById(R.id.iv_profile_small);
            profileImage.setImageBitmap(b);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }


}