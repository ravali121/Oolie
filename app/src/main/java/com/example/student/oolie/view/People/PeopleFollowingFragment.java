package com.example.student.oolie.view.People;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.student.oolie.R;

import java.util.ArrayList;
import java.util.List;


public class PeopleFollowingFragment extends Fragment {

    private RecyclerView.Adapter adapter;
    private List<PeopleFollowingListItem> peopleFollowingListItems;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_people_following, container, false);

        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.rv_people_following);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        peopleFollowingListItems = new ArrayList<>();

        for(int i=0;i<=10;i++){
            PeopleFollowingListItem peopleFollowingListItem = new PeopleFollowingListItem(
                    "Username"+i+1,
                    "Gradlevel"+i+1,
                    "SchoolName"+i+1
            );
            peopleFollowingListItems.add(peopleFollowingListItem);
        }

        adapter = new PeopleFollowingAdapter(peopleFollowingListItems,getActivity());
        recyclerView.setAdapter(adapter);
        return rootView;
    }






}
