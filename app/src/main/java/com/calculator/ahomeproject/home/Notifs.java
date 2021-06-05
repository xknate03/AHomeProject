package com.calculator.ahomeproject.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.calculator.ahomeproject.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class Notifs extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifs);

        //Initialize and assign variable
        bottomNavigationView = findViewById(R.id.bottomNavViewBar);

        //set home selected
        bottomNavigationView.setSelectedItemId(R.id.ic_notifs);
        performItemSelectedListener();

    }


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