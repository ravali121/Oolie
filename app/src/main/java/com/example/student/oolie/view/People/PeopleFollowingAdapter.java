package com.example.student.oolie.view.People;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.student.oolie.R;

import java.util.List;

/**
 * Created by Student on 8/4/17.
 */

public class PeopleFollowingAdapter extends RecyclerView.Adapter<PeopleFollowingAdapter.ViewHolder> {


    private List<PeopleFollowingListItem> peopleFollowingListItems;
    private Context context;

    public PeopleFollowingAdapter(List<PeopleFollowingListItem> peopleFollowingListItems, Context context) {
        this.peopleFollowingListItems = peopleFollowingListItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.people_following_list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PeopleFollowingListItem peopleFollowingListItem = peopleFollowingListItems.get(position);
        holder.username.setText(peopleFollowingListItem.getUsername());
        holder.gradlevel.setText(peopleFollowingListItem.getGradLevel());
        holder.school.setText(peopleFollowingListItem.getSchoolName());

    }

    @Override
    public int getItemCount() {
        return peopleFollowingListItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView username;
        public TextView gradlevel;
        public TextView school;

        public ViewHolder(View itemView) {
            super(itemView);

            username = (TextView)itemView.findViewById(R.id.tv_following_name);
            gradlevel = (TextView)itemView.findViewById(R.id.tv_gradlevel);
            school = (TextView) itemView.findViewById(R.id.tv_school_name);
        }
    }


}
