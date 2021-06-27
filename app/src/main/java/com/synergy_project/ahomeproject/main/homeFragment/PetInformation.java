package com.synergy_project.ahomeproject.main.homeFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.synergy_project.ahomeproject.R;
import com.synergy_project.ahomeproject.main.MainActivity;
import com.synergy_project.ahomeproject.main.chatFragment.ChatBox;

public class PetInformation extends AppCompatActivity implements View.OnClickListener {
    ImageView petImage_petInfo_activity;
    Button btnChat;
    boolean isImageFitToScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_information);

        petImage_petInfo_activity = findViewById(R.id.petImage_petInfo_activity);
        btnChat = findViewById(R.id.btnSample);

        btnChat.setOnClickListener(this);
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
    public void onClick(View v) {
        Intent intent = new Intent(PetInformation.this, ChatBox.class);
        startActivity(intent);
    }

    public void goBack(View view) {
        startActivity(new Intent(this, MainActivity.class));

    }

}