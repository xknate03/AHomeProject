package com.calculator.ahomeproject.home.postFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.calculator.ahomeproject.R;
import com.calculator.ahomeproject.home.MainActivity;

public class ForAdoption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_adoption);
    }

    public void goBack(View view) {
        startActivity(new Intent(ForAdoption.this, MainActivity.class));
    }
}