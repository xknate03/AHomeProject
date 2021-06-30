package com.synergy_project.ahomeproject.main.postFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.synergy_project.ahomeproject.R;
import com.synergy_project.ahomeproject.main.MainActivity;

public class PostSomething extends AppCompatActivity {
    ImageView imgBack_post_something_act;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_something);


        imgBack_post_something_act = findViewById(R.id.imgBack_post_something_act);


    }

    public void goBack(View view) {
        this.finish();
    }

    public void postSomething(View view) {
        startActivity(new Intent(PostSomething.this, MainActivity.class));
    }
}