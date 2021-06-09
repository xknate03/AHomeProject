package com.calculator.ahomeproject.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;

import com.calculator.ahomeproject.R;
import com.calculator.ahomeproject.home.post.Post;
import com.calculator.ahomeproject.home.profile.Profile;
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
        bottomNavigationView = findViewById(R.id.bottomNavViewBar);
        //set home selected
        bottomNavigationView.setSelectedItemId(R.id.ic_home);
        performItemSelectedListener();

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



    public void performItemSelectedListener() {
        //Perform ItemSelected Listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.ic_home:
                        return true;
                    case R.id.ic_groups:
                        startActivity(new Intent(getApplicationContext(), Groups.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_post:
                        startActivity(new Intent(getApplicationContext(), Post.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_notifs:
                        startActivity(new Intent(getApplicationContext(), Notifs.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_profile:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0,0);
                        return true;



                }
                return false;
            }
        });
    }

}