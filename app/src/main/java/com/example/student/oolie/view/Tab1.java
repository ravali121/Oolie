package com.example.student.oolie.view;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageRequest;
import com.example.student.oolie.R;
import com.example.student.oolie.data.DataSource;
import com.example.student.oolie.data.ListItem;
import com.example.student.oolie.logic.Controller;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Student on 7/10/17.
 */

public class Tab1 extends Fragment implements ViewInterface{

    private static final String EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME";
    private static final String EXTRA_COMMENT = "EXTRA_COMMENT";
    private static final String EXTRA_SCHOOL_NAME = "EXTRA_SCHOOL_NAME";
    private static final String EXTRA_SCHOOL_LOGO = "EXTRA_SCHOOL_LOGO";


    private List<ListItem> listOfData;
    private RecyclerView recyclerView;
    private LayoutInflater layoutInflater;
    private CustomAdapter adapter;
    private Controller controller;
    Context context;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1,container,false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_feed);
        //Dependency injection
         controller = new Controller(this, new DataSource());
        return rootView;
    }


    @Override
    public void startDetailActivity(String dateAndTime, String posts, String schoolName, int schoolLogo) {
        /*Intent intent = new Intent(getActivity(), FeedDetailActivity.class);
        intent.putExtra(EXTRA_DATE_AND_TIME,dateAndTime);
        intent.putExtra(EXTRA_COMMENT,comment);
        intent.putExtra(EXTRA_SCHOOL_NAME,schoolName);
        intent.putExtra(EXTRA_SCHOOL_LOGO,schoolLogo);*/
    }

    @Override
    public void setUpAdapterAndView(List<ListItem> listOfData) {
        this.listOfData = listOfData;
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),llm.getOrientation()));
        adapter= new CustomAdapter();
        recyclerView.setAdapter(adapter);
    }



    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{


        @Override
        public int getItemViewType(int position){
            return listOfData.get(position).getType();
        }

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = layoutInflater.from(parent.getContext()).inflate(R.layout.tab1_data_items,parent,false);
            context = parent.getContext();
            return new CustomViewHolder(v);
        }
        @Override
        public void onBindViewHolder(CustomViewHolder holder, int position) {
             ListItem currentItem = listOfData.get(position);

            Picasso.with(context).load(currentItem.getPosts()).into(holder.post);
            //holder.post.setBackgroundResource(currentItem.getPosts());
            holder.date_posted.setText(currentItem.getDateAndTime());
            holder.school_name.setText(currentItem.getSchoolName());
            holder.school_logo.setBackgroundResource(currentItem.getSchoolLogo());
        }
        @Override
        public int getItemCount() {
            //Number of items the adapter needs to manage
            return listOfData.size();
        }

        //Create a nested class
        class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            private ImageView school_logo;
            private ImageView post;
            private TextView date_posted;
            private TextView school_name;
            private ViewGroup container;

            public CustomViewHolder(View itemView) {
                super(itemView);

                this.school_logo = (ImageView)itemView.findViewById(R.id.iv_school_logo);
                this.post = (ImageView) itemView.findViewById(R.id.tv_post);
                this.date_posted = (TextView)itemView.findViewById(R.id.tv_date_posted);
                this.school_name = (TextView)itemView.findViewById(R.id.tv_school_name);
                this.container=(ViewGroup)itemView.findViewById(R.id.container);
                this.container.setOnClickListener(this);

            }
            @Override
            public void onClick(View view) {
                //Get the position of this ViewHolder with in the adapter
                ListItem listItem = listOfData.get(this.getAdapterPosition());
                controller.onListItemClick(listItem);

            }
        }
    }



}

