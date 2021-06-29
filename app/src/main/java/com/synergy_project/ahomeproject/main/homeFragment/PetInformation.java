package com.synergy_project.ahomeproject.main.homeFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.synergy_project.ahomeproject.R;
import com.synergy_project.ahomeproject.main.MainActivity;
import com.synergy_project.ahomeproject.main.chatFragment.ChatBox;

public class PetInformation extends AppCompatActivity implements View.OnClickListener {
    ImageView petImage_petInfo_activity;
    TextView txtPetName_petInfo_activity, txtPetSex_petInfo_activity, txtPetType_petInfo_activity;
    TextView txtPetStatus_petInfo_activity, txtPetAge_petInfo_activity, txtPetColor_petInfo_activity;
    TextView txtPetLocation_petInfo_activity, txtPetDescription_petInfo_activity;
    String petName, petType, petSex, petStatus, petDescription;
    String petAge, petColor, petLocation;
    int petImage;
    Button btnChat;
    boolean isImageFitToScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_information);

        txtPetName_petInfo_activity = findViewById(R.id.txtPetName_petInfo_activity);
        petImage_petInfo_activity = findViewById(R.id.petImage_petInfo_activity);
        txtPetType_petInfo_activity = findViewById(R.id.txtPetType_petInfo_activity);
        txtPetStatus_petInfo_activity = findViewById(R.id.txtPetStatus_petInfo_activity);
        txtPetSex_petInfo_activity = findViewById(R.id.txtPetSex_petInfo_activity);
        txtPetAge_petInfo_activity = findViewById(R.id.txtPetAge_petInfo_activity);
        txtPetColor_petInfo_activity = findViewById(R.id.txtPetColor_petInfo_activity);
        txtPetLocation_petInfo_activity = findViewById(R.id.txtPetLocation_petInfo_activity);
        txtPetDescription_petInfo_activity = findViewById(R.id.txtPetDescription_petInfo_activity);

        getData();
        setData();
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


    private void getData() {
        if( getIntent().hasExtra("petName") && getIntent().hasExtra("petImage") ) {
            petName = getIntent().getStringExtra("petName");
            petImage = getIntent().getIntExtra("petImage", 1);
            petType = getIntent().getStringExtra("petType");
            petSex = getIntent().getStringExtra("petSex");
            petStatus = getIntent().getStringExtra("petStatus");
            petAge = getIntent().getStringExtra("petAge");
            petColor = getIntent().getStringExtra("petColor");
            petLocation = getIntent().getStringExtra("petLocation");
            petDescription  = getIntent().getStringExtra("description");

        }else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        txtPetName_petInfo_activity.setText(String.format("Name: %s", petName));
        petImage_petInfo_activity.setImageResource(petImage);
        txtPetType_petInfo_activity.setText(String.format("Type: %s", petType));
        txtPetStatus_petInfo_activity.setText(String.format("Status: %s", petStatus));
        txtPetSex_petInfo_activity.setText(String.format("Sex: %s", petSex));
        txtPetAge_petInfo_activity.setText(String.format("Age: %s", petAge));
        txtPetColor_petInfo_activity.setText(String.format("Color: %s", petColor));
        txtPetLocation_petInfo_activity.setText(String.format("Location: %s", petLocation));
        txtPetDescription_petInfo_activity.setText(petDescription);



    }

}