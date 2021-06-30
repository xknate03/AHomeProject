package com.synergy_project.ahomeproject.main.homeFragment;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import com.synergy_project.ahomeproject.R;
import com.synergy_project.ahomeproject.main.chatFragment.ChatBox;
import com.synergy_project.ahomeproject.main.chatFragment.ChatList;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    EditText edtSearchBar_home_fragment;
    SwipeRefreshLayout swipe_refresh;
    String[] petName, petType, description, petSex, petStatus;
    String[] petAge, petColor, petLocation;
    int[] petImage = {R.drawable.bella, R.drawable.browny, R.drawable.george, R.drawable.jake, R.drawable.max, R.drawable.tiny};
//    Button btnSample;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        edtSearchBar_home_fragment = v.findViewById(R.id.edtSearchBar_home_fragment);
        swipe_refresh = v.findViewById(R.id.swipe_refresh);
        //setting size of the imageView programmatically
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = (int) (size.x * 0.65);
        edtSearchBar_home_fragment.setWidth(width);

        //buttons


        //for recyclerView
        petName = getResources().getStringArray(R.array.petNames);
        petType = getResources().getStringArray(R.array.petType);
        description = getResources().getStringArray(R.array.description);
        petSex = getResources().getStringArray(R.array.petSex);
        petStatus = getResources().getStringArray(R.array.petStatus);
        petAge = getResources().getStringArray(R.array.petAge);
        petColor = getResources().getStringArray(R.array.petColor);
        petLocation = getResources().getStringArray(R.array.petLocation);


        RecyclerView recyclerView =  v.findViewById(R.id.recyclerView_fragment_home);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), petName, petType,
                description, petImage, petSex, petStatus, petAge, petColor, petLocation);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(adapter);

        swipe_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipe_refresh.setRefreshing(false);
            }
        });


        return v;
    }


}
