package com.synergy_project.ahomeproject.main.groupsFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.synergy_project.ahomeproject.R;

import org.jetbrains.annotations.NotNull;

public class GroupsFragment extends Fragment {
    //declare here
    String[] group_name, group_timeStamp, group_postContent;
    RecyclerView fragment_groups_recyclerView;
    int[] images = new int[]{R.drawable.jake, R.drawable.george, R.drawable.browny,R.drawable.bella,};


    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_groups, container, false);

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
