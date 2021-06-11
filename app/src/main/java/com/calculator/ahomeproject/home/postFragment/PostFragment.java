package com.calculator.ahomeproject.home.postFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.calculator.ahomeproject.R;
import com.calculator.ahomeproject.login.LoginActivity;

import org.jetbrains.annotations.NotNull;

public class PostFragment extends Fragment {
    Button btnPost_post_fragment, btnForAdoption_post_fragment;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override

    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_post, container, false);
//
        btnPost_post_fragment = v.findViewById(R.id.btnPost_post_fragment);
        btnForAdoption_post_fragment = v.findViewById(R.id.btnForAdoption_post_fragment);

        btnPost_post_fragment.setOnClickListener(v1 -> {
            Intent in = new Intent(getContext(), PostSomething.class);
            startActivity(in);
        });

        btnForAdoption_post_fragment.setOnClickListener(v12 -> {
            Intent intent = new Intent(getContext(), ForAdoption.class);
            startActivity(intent);
        });

        return v;
    }
}
