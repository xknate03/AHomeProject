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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.synergy_project.ahomeproject.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    EditText edtSearchBar_home_fragment;
    RecyclerView dataList_fragmentHome;
    List<Book> bookList;
    Button btnSample;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        edtSearchBar_home_fragment = v.findViewById(R.id.edtSearchBar_home_fragment);

        //setting size of the imageView programmatically
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = (int) (size.x * 0.65);
        edtSearchBar_home_fragment.setWidth(width);


        //for recyclerView
        bookList = new ArrayList<>();
        bookList.add(new Book("Bella", "Cat", "Description", R.drawable.bella));
        bookList.add(new Book("Browny", "Dog", "Description", R.drawable.browny));
        bookList.add(new Book("George", "Cat", "Description", R.drawable.george));
        bookList.add(new Book("Jake", "Dog", "Description", R.drawable.jake));
        bookList.add(new Book("Max", "Dog", "Description", R.drawable.max));
        bookList.add(new Book("Tiny", "Dog", "Description", R.drawable.tiny));
        bookList.add(new Book("Bella", "Cat", "Description", R.drawable.bella));
        bookList.add(new Book("Browny", "Dog", "Description", R.drawable.browny));
        bookList.add(new Book("George", "Cat", "Description", R.drawable.george));
        bookList.add(new Book("Jake", "Dog", "Description", R.drawable.jake));
        bookList.add(new Book("Max", "Dog", "Description", R.drawable.max));
        bookList.add(new Book("Tiny", "Dog", "Description", R.drawable.tiny));


        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView_fragment_home);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), bookList);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(adapter);

        //for opening the pet information activity
        btnSample = v.findViewById(R.id.btnSample);
        btnSample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), PetInformation.class));
            }
        });



        return v;
    }
}
