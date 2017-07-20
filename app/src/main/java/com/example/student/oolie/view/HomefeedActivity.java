package com.example.student.oolie.view;

import android.graphics.Bitmap;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.student.oolie.R;

public class HomefeedActivity extends AppCompatActivity {


    private ViewPager viewPager;
    TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;
    ImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homefeed);

         Bitmap bitmap = (Bitmap)this.getIntent().getParcelableExtra("Bitmap");
        profileImage = (ImageView)findViewById(R.id.iv_profile_small);
        profileImage.setImageBitmap(bitmap);

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


}