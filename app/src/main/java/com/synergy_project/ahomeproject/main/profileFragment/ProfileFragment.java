package com.synergy_project.ahomeproject.main.profileFragment;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.synergy_project.ahomeproject.R;
import com.google.android.material.tabs.TabLayout;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.parse.ParseUser;

import org.jetbrains.annotations.NotNull;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {
    TextView fragment_toolbar_title, txtBio_profile_fragment, txtName_profile_fragment;
    TextView txtUsername_profile_fragment, txtLocation_profile_fragment;
    Toolbar fragment_toolbar;
    TabLayout tabLayout_profile_fragment;
    ViewPager2 viewPager_profile_fragment;
    FragmentAdapter adapter;
    Button btnEditProfile_profile_fragment, btnChat_fragProfile;
    SwipeRefreshLayout swipe_refresh;
    SharedPreferences prefs;
    CircleImageView imgpImage_profile;
    Uri imageUri;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable
            ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        //buttons
        //Text Views
        txtBio_profile_fragment = v.findViewById(R.id.txtBio_profile_fragment);
        txtName_profile_fragment = v.findViewById(R.id.txtName_profile_fragment);
        txtUsername_profile_fragment = v.findViewById(R.id.txtUsername_profile_fragment);
        txtLocation_profile_fragment = v.findViewById(R.id.txtLocation_profile_fragment);
        //for toolbar declaration
        fragment_toolbar_title = v.findViewById(R.id.fragment_toolbar_title);
        btnEditProfile_profile_fragment = v.findViewById(R.id.btnEditProfile_profile_fragment);
        fragment_toolbar = v.findViewById(R.id.fragment_toolbar);
        //for tab layout
        tabLayout_profile_fragment = v.findViewById(R.id.tabLayout_profile_fragment);
        viewPager_profile_fragment = v.findViewById(R.id.viewPager_profile_fragment);
        FragmentManager fm = ((AppCompatActivity) getActivity()).getSupportFragmentManager();
        adapter = new FragmentAdapter(fm, getLifecycle());
        viewPager_profile_fragment.setAdapter(adapter);
        //for swipe refresh
        swipe_refresh = v.findViewById(R.id.swipe_refresh);

        imgpImage_profile = v.findViewById(R.id.rows_imgProfile);


        //adding tabLayout tab names
        String[] tabNames = {"Posts", "Listing", "About"};

        addThreeTabNames(tabLayout_profile_fragment, tabNames);
        addTabListener(tabLayout_profile_fragment, viewPager_profile_fragment);
        viewPager_profile_fragment.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout_profile_fragment.selectTab(tabLayout_profile_fragment.getTabAt(position));
            }
        });

        //for toolbar
        if (fragment_toolbar != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(fragment_toolbar);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        String usernameWithAt = "@" + ParseUser.getCurrentUser().getUsername();
        fragment_toolbar_title.setText(usernameWithAt);

        //for setting initial value of textViews, before editing profile
        prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        String prof_name = prefs.getString("prof_name", "Profile name");
        String prof_user = "@" + prefs.getString("prof_user", "Profile username");
        String prof_bio = prefs.getString("prof_bio", "Profile Bio");
        String prof_loc = prefs.getString("prof_loc", "Profile Location");

        //Default for new User
        txtName_profile_fragment.setText(prof_name);
        txtUsername_profile_fragment.setText(prof_user);
        txtBio_profile_fragment.setText(prof_bio);
        txtLocation_profile_fragment.setText(prof_loc);

        btnEditProfile_profile_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new DialogFragment();
                dialogFragment.show(((AppCompatActivity) getActivity()).getSupportFragmentManager(), "Dialog");
            }
        });

        //for swipeRefresh layout
        swipe_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                String prof_name = prefs.getString("prof_name", "Profile name");
                String prof_user = "@" + prefs.getString("prof_user", "Profile username");
                String prof_bio = prefs.getString("prof_bio", "Profile Bio");
                String prof_loc = prefs.getString("prof_loc", "Profile Location");
                txtName_profile_fragment.setText(prof_name);
                txtUsername_profile_fragment.setText(prof_user);
                txtBio_profile_fragment.setText(prof_bio);
                txtLocation_profile_fragment.setText(prof_loc);

                swipe_refresh.setRefreshing(false);
            }
        });

        imgpImage_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runTimePermission();
            }
        });


        return v;
    }
    // end of onCreateView method


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

        if (requestCode == 100 && data != null) {
            imageUri = data.getData();
            imgpImage_profile.setImageURI(imageUri);
        }
    }

    //for tab layout
    //adding tab names to tab layout
    public void addThreeTabNames(TabLayout tabLayout, String[] tabNames) {
        tabLayout.addTab(tabLayout_profile_fragment.newTab().setText(tabNames[0]));
        tabLayout.addTab(tabLayout_profile_fragment.newTab().setText(tabNames[1]));
        tabLayout.addTab(tabLayout_profile_fragment.newTab().setText(tabNames[2]));
    }

    //adding tab listener and setting pager
    public void addTabListener(TabLayout tabLayout, ViewPager2 viewPager_profile) {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager_profile.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }




}
