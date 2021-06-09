package com.calculator.ahomeproject.home.profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.calculator.ahomeproject.R;
import com.calculator.ahomeproject.home.Groups;
import com.calculator.ahomeproject.home.MainActivity;
import com.calculator.ahomeproject.home.Notifs;
import com.calculator.ahomeproject.home.post.Post;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Profile extends AppCompatActivity implements DialogFragment.OnInputListener{
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    TextView toolbar_title, txtBio_profile, txtName_profile, txtUsername_profile, txtLocation_profile;
    TabLayout tabLayout_profile;
    ViewPager2 viewPager_profile;
    FragmentAdapter adapter;

    String testing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Text Views
        txtBio_profile = findViewById(R.id.txtBio_profile);
        txtName_profile = findViewById(R.id.txtName_profile);
        txtUsername_profile = findViewById(R.id.txtUsername_profile);
        txtLocation_profile = findViewById(R.id.txtLocation_profile);

        toolbar = findViewById(R.id.toolbar);
        toolbar_title = findViewById(R.id.toolbar_title);
        //for bottom navigation view
        bottomNavigationView = findViewById(R.id.bottomNavViewBar);
        //set home selected
        bottomNavigationView.setSelectedItemId(R.id.ic_profile);
        performItemSelectedListener();

        //for toolbar
        setSupportActionBar(toolbar);
        String usernameWithAt = "@" + ParseUser.getCurrentUser().getUsername();
        toolbar_title.setText(usernameWithAt);


        //for setting initial value of textViews, before editing profile
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String prof_name = prefs.getString("prof_name", "Profile name");
        String prof_user = "@" + prefs.getString("prof_user", "Profile username");
        String prof_bio = prefs.getString("prof_bio", "Profile Bio");
        String prof_loc = "@" + prefs.getString("prof_loc", "Profile Location");
        txtName_profile.setText(prof_name);
        txtUsername_profile.setText(prof_user);
        txtBio_profile.setText(prof_bio);
        txtLocation_profile.setText(prof_loc);




        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        //for tabbed layout
        tabLayout_profile = findViewById(R.id.tabLayout_profile);
        viewPager_profile = findViewById(R.id.viewPager_profile);
        FragmentManager fm = getSupportFragmentManager();
        adapter = new FragmentAdapter(fm, getLifecycle());
        viewPager_profile.setAdapter(adapter);

        //adding tabLayout tab names
        String[] tabNames = {"Posts", "Listing", "About"};
        addThreeTabNames(tabLayout_profile, tabNames);
        //adding listener
        addTabListener(tabLayout_profile);
        viewPager_profile.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout_profile.selectTab(tabLayout_profile.getTabAt(position));
            }
        });




    }
    // end of onCreate method

    public void editProfileListener(View view) {
        //for btnEditProfile_profile = findViewById(R.id.btnEditProfile_profile);
        DialogFragment dialogFragment = new DialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "Dialog");

    }


    public ParseQuery<ParseObject> newQuery(String className) {
        return new ParseQuery<ParseObject>(className);
    }

    //for tab layout
    //adding tab names to tab layout
    public void addThreeTabNames(TabLayout tabLayout, String[] tabNames) {
        tabLayout.addTab(tabLayout_profile.newTab().setText(tabNames[0]));
        tabLayout.addTab(tabLayout_profile.newTab().setText(tabNames[1]));
        tabLayout.addTab(tabLayout_profile.newTab().setText(tabNames[2]));

    }

    //adding tab listener and setting pager
    public void addTabListener(TabLayout tabLayout) {
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

    //for toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getGroupId();

        if (id == R.id.paw) {
            Toast.makeText(this, "You click settings", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.chat) {
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
                switch (item.getItemId()) {
                    case R.id.ic_home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.ic_groups:
                        startActivity(new Intent(getApplicationContext(), Groups.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.ic_post:
                        startActivity(new Intent(getApplicationContext(), Post.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.ic_notifs:
                        startActivity(new Intent(getApplicationContext(), Notifs.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.ic_profile:
                        return true;
                }
                return false;
            }
        });
    }


    @Override
    public void updateName(String input) {
        txtName_profile.setText(input);

    }

    @Override
    public void updateLocation(String input) {
        txtLocation_profile.setText(input);
    }

    @Override
    public void updateBio(String input) {
        txtBio_profile.setText(input);
    }
}