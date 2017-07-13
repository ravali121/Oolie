package com.example.student.oolie;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.oolie.data.ListItem;

import java.util.List;

/**
 * Created by Student on 7/10/17.
 */

public class Tab1 extends Fragment {


    private List<ListItem> listOfData;
    private RecyclerView recyclerView;
    private LayoutInflater layoutInflater;
    private CustomAdapter adapter;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1,container,false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_feed);
        return rootView;
    }
}
