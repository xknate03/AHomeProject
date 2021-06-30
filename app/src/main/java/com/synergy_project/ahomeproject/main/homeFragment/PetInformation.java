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
import com.synergy_project.ahomeproject.main.chatFragment.ChatList;

public class PetInformation extends AppCompatActivity {
    ImageView petImage_petInfo_activity;
    TextView txtPetName_petInfo_activity, txtPetSex_petInfo_activity, txtPetType_petInfo_activity;
    TextView txtPetStatus_petInfo_activity, txtPetAge_petInfo_activity, txtPetColor_petInfo_activity;
    TextView txtPetLocation_petInfo_activity, txtPetDescription_petInfo_activity;
    String petName, petType, petSex, petStatus, petDescription;
    String petAge, petColor, petLocation;
    int petImage;
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

    public void openChatActivity(View view) {
        Intent intent = new Intent(this, ChatList.class);
        startActivity(intent);
    }

    public void goBackToMain(View view) {
        this.finish();
    }
}