package com.synergy_project.ahomeproject.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.synergy_project.ahomeproject.R;
import com.synergy_project.ahomeproject.main.groupsFragment.GroupsFragment;
import com.synergy_project.ahomeproject.main.homeFragment.HomeFragment;
import com.synergy_project.ahomeproject.main.notifsFragment.NotifsFragment;
import com.synergy_project.ahomeproject.main.postFragment.PostFragment;
import com.synergy_project.ahomeproject.main.profileFragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize and assign variable
        //using fragments:
        bottomNavigationView = findViewById(R.id.bottomNavViewBar);

        performItemSelectedListener(bottomNavigationView);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();


        //connecting to ParseServer
        //creating a parse query to get the username by using whereEqualTo, setting limit of object collected to 1
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Profile");
        query.whereEqualTo("user_name", ParseUser.getCurrentUser().getUsername());
        query.setLimit(1);
        //getting the objectID first to call getInBackground
        query.findInBackground((objects, e) -> {
            String objectID = "";
            for (ParseObject object : objects) {
                objectID = object.getObjectId();
            }
            //creating another query  to set values of TextViews
            ParseQuery<ParseObject> query1 = new ParseQuery<ParseObject>("Profile");
            query1.getInBackground(objectID, (object, e1) -> {
                if (e == null) {
                    String prof_name = object.get("full_name").toString();
                    String prof_user = object.get("user_name").toString();
                    String prof_bio = object.get("bio").toString();
                    String prof_loc = object.get("location").toString();

                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("prof_name", prof_name);
                    editor.putString("prof_user", prof_user);
                    editor.putString("prof_bio", prof_bio);
                    editor.putString("prof_loc", prof_loc);
                    editor.apply();


                } else {
                    Log.d("Tag", e.getMessage());
                }
            });
        });
    }
    //end of onCreate


    public void performItemSelectedListener(BottomNavigationView bottomNavigationView) {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.ic_home:
                        bottomNavigationView.setVisibility(View.VISIBLE);
                        selectedFragment= new HomeFragment();
                        break;
                    case R.id.ic_groups:
                        bottomNavigationView.setVisibility(View.VISIBLE);
                        selectedFragment= new GroupsFragment();
                        break;
                    case R.id.ic_post:
                        bottomNavigationView.setVisibility(View.VISIBLE);
                        selectedFragment= new PostFragment();

                        break;
                    case R.id.ic_notifs:
                        bottomNavigationView.setVisibility(View.VISIBLE);
                        selectedFragment= new NotifsFragment();
                        break;
                    case R.id.ic_profile:
                        bottomNavigationView.setVisibility(View.VISIBLE);
                        selectedFragment= new ProfileFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            }
        });
    }



}