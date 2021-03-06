package com.example.marko.areyou4real.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marko.areyou4real.CreateEvent;
import com.example.marko.areyou4real.CreateGroup;
import com.example.marko.areyou4real.R;
import com.example.marko.areyou4real.fragments.adapter.EventRecyclerAdapter;
import com.example.marko.areyou4real.fragments.adapter.GroupsRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Random;

public class GroupsFragment extends android.support.v4.app.Fragment {
    private SwipeRefreshLayout swipe;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Context mContext ;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference eventsRef = db.collection("Groups");
    private FirebaseAuth auth = FirebaseAuth.getInstance();
    private String userId = auth.getUid();
    private ArrayList<Group> groupsList = new ArrayList<>();
    FloatingActionButton floatingActionButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.groups_layout, container, false);
        swipe = view.findViewById(R.id.groupSwipe);
        mContext= getContext();

        floatingActionButton = view.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateGroup.class);
                startActivity(intent);
            }
        });

        ArrayList<String> strings = new ArrayList<>();
        strings.add("afasgsagagag");


        groupsList.add(new Group("family",strings,strings.size(),null,"asfasfsafas"));


        mRecyclerView = view.findViewById(R.id.container);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(mContext,2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new GroupsRecyclerAdapter(mContext,groupsList);
        mRecyclerView.setAdapter(mAdapter);





        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipe.setRefreshing(true);
                (new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipe.setRefreshing(false);

                        int min = 15;
                        int max = 25;
                        Random random = new Random();
                        int i = random.nextInt(max - min + 1) + min;
                    }
                }, 1000);
            }
        });
        return view;
    }
}
