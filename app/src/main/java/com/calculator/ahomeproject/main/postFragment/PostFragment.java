package com.calculator.ahomeproject.main.postFragment;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.calculator.ahomeproject.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import org.jetbrains.annotations.NotNull;

public class PostFragment extends Fragment {
    Button btnPost_post_fragment, btnForAdoption_post_fragment;
    Uri imageUri;

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
            runTimePermission();
        });

        return v;
    }

    // for getting images from gallery for uploading
    private void runTimePermission() {
        Dexter.withContext(getContext())
                .withPermission(
                        Manifest.permission.READ_EXTERNAL_STORAGE
                ).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                galleryIntent();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).check();
    }

    private void galleryIntent() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 100);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && data != null) {
            imageUri = data.getData();
            Intent in = new Intent(getContext(), ForAdoption.class);
            in.putExtra("img_Upload", imageUri.toString());
            startActivity(in);
        }
    }
}
