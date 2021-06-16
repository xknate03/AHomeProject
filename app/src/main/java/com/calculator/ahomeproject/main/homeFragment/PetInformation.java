package com.calculator.ahomeproject.main.homeFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.calculator.ahomeproject.R;
import com.calculator.ahomeproject.main.MainActivity;

public class PetInformation extends AppCompatActivity {
    ImageView petImage_petInfo_activity;
    boolean isImageFitToScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_information);

        petImage_petInfo_activity = findViewById(R.id.petImage_petInfo_activity);

//        if (isImageFitToScreen) {
//            isImageFitToScreen = false;
//            petImage_petInfo_activity.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//            petImage_petInfo_activity.setAdjustViewBounds(true);
//        } else {
//            isImageFitToScreen = true;
//            petImage_petInfo_activity.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
//            petImage_petInfo_activity.setScaleType(ImageView.ScaleType.FIT_XY);
//        }

    }


    public void goBack(View view) {
        startActivity(new Intent(this, MainActivity.class));

    }

}