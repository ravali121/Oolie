package com.example.student.oolie.view.More;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.student.oolie.R;
import com.example.student.oolie.view.Home.HomefeedActivity;
import com.example.student.oolie.view.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MoreActivity extends AppCompatActivity {
    private static final int ACTIVITY_NUM = 4;
    private Context mContext = MoreActivity.this;
    FloatingActionButton fab_plus, fab_invite, fab_maps, fab_post;
    Animation FabOpen, FabClose,FabRClockwise, FabRanticlockwise;
    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        fab_plus = (FloatingActionButton)findViewById(R.id.fab_plus);
        fab_invite=(FloatingActionButton)findViewById(R.id.fab_invite);
        fab_maps = (FloatingActionButton)findViewById(R.id.fab_maps);
        fab_post=(FloatingActionButton)findViewById(R.id.fab_attach);
        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        FabRClockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        FabRanticlockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);
        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOpen){
                    fab_invite.startAnimation(FabClose);
                    fab_maps.startAnimation(FabClose);
                    fab_post.startAnimation(FabClose);
                    fab_plus.startAnimation(FabRanticlockwise);
                    fab_invite.setClickable(false);
                    fab_maps.setClickable(false);
                    fab_post.setClickable(false);
                    isOpen = false;

                }else{
                    fab_invite.startAnimation(FabOpen);
                    fab_maps.startAnimation(FabOpen);
                    fab_post.startAnimation(FabOpen);
                    fab_plus.startAnimation(FabRClockwise);
                    fab_invite.setClickable(true);
                    fab_maps.setClickable(true);
                    fab_post.setClickable(true);
                    isOpen = true;
                }
            }
        });



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
