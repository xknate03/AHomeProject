package com.synergy_project.ahomeproject.main.groupsFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.synergy_project.ahomeproject.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GroupsFragment extends Fragment {
    //declare here
    String[] group_name, group_timeStamp, group_postContent;
    String[] group_myGroup;
    RecyclerView fragment_groups_recyclerView, fragment_groups_recyclerView_horizontal, fragment_groups_recyclerView_horizontal2 ;
    int[] images = new int[]{R.drawable.jake, R.drawable.george, R.drawable.browny,R.drawable.bella};
    int[] group_myGroup_images = new int[]{R.drawable.cat_lovers, R.drawable.dog_lovers};


    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_groups, container, false);

        fragment_groups_recyclerView_horizontal = view.findViewById(R.id.fragment_groups_recyclerView_horizontal);
        fragment_groups_recyclerView_horizontal2 = view.findViewById(R.id.fragment_groups_recyclerView_horizontal2);
        //discover groups recyclerView
        fragment_groups_recyclerView_horizontal2.setItemAnimator(new DefaultItemAnimator());
        group_myGroup = getResources().getStringArray(R.array.group_group_names);
        HorizontalAdapter2 horizontalAdapter2 = new HorizontalAdapter2(getContext(), group_myGroup, group_myGroup_images);
        fragment_groups_recyclerView_horizontal2.setAdapter(horizontalAdapter2);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        fragment_groups_recyclerView_horizontal2.setLayoutManager(layoutManager2);

        //my groups list
        fragment_groups_recyclerView_horizontal.setItemAnimator(new DefaultItemAnimator());
        group_myGroup = getResources().getStringArray(R.array.group_group_names);
        HorizontalAdapter horizontalAdapter = new HorizontalAdapter(getContext(), group_myGroup, group_myGroup_images);
        fragment_groups_recyclerView_horizontal.setAdapter(horizontalAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        fragment_groups_recyclerView_horizontal.setLayoutManager(layoutManager);

        //group members post
        fragment_groups_recyclerView = view.findViewById(R.id.fragment_groups_recyclerView);
        group_name = getResources().getStringArray(R.array.group_users);
        group_timeStamp = getResources().getStringArray(R.array.group_timeStamp);
        group_postContent = getResources().getStringArray(R.array.group_postContent);
        GroupsAdapter GroupsAdapter = new GroupsAdapter(getContext(), group_name, group_timeStamp, group_postContent, images);
        fragment_groups_recyclerView.setAdapter(GroupsAdapter);
        fragment_groups_recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}
