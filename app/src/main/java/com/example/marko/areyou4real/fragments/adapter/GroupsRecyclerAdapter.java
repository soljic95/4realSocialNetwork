package com.example.marko.areyou4real.fragments.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marko.areyou4real.R;
import com.example.marko.areyou4real.fragments.Group;

import java.util.ArrayList;

public class GroupsRecyclerAdapter extends RecyclerView.Adapter<GroupsRecyclerAdapter.MyViewHolder> {
    Context mcontext;
    ArrayList<Group> grupsList;

    public GroupsRecyclerAdapter(Context mcontext, ArrayList<Group> grupsList) {
        this.mcontext = mcontext;
        this.grupsList = grupsList;
    }

    @NonNull
    @Override
    public GroupsRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.groups_layout_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupsRecyclerAdapter.MyViewHolder holder, int position) {
        holder.groupItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext, "well shit", Toast.LENGTH_SHORT).show();
            }
        });
        holder.groupName.setText(grupsList.get(position).getGroupName());
    }

    @Override
    public int getItemCount() {
        return grupsList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout groupItem;
        ImageView groupImage;
        TextView groupName;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.groupImage = itemView.findViewById(R.id.ivGroupImage);
            this.groupItem = itemView.findViewById(R.id.groupsItemLayout);
            this.groupName = itemView.findViewById(R.id.tvGroupName);
        }
    }
}
