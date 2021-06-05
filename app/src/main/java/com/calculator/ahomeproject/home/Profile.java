package com.calculator.ahomeproject.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.calculator.ahomeproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.ParseUser;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Profile extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    TextView toolbar_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        toolbar = findViewById(R.id.toolbar);
        toolbar_title = findViewById(R.id.toolbar_title);
        bottomNavigationView = findViewById(R.id.bottomNavViewBar);

        //for bottom navigation view
        //Initialize and assign variable

        //set home selected
        bottomNavigationView.setSelectedItemId(R.id.ic_profile);
        performItemSelectedListener();

        //for toolbar
        setSupportActionBar(toolbar);
        String usernameWithAt = "@" + ParseUser.getCurrentUser().getUsername();
        toolbar_title.setText( usernameWithAt);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);




    }





    //for toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getGroupId();

        if(id == R.id.paw) {
            Toast.makeText(this, "You click settings", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.chat) {
            Toast.makeText(this, "You click search", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    //for bottom nav
    public void performItemSelectedListener() {
        //Perform ItemSelected Listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.ic_home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
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

                        return true;



                }
                return false;
            }
        });
    }
}