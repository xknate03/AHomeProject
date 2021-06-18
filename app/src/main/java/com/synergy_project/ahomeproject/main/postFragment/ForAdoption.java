package com.synergy_project.ahomeproject.main.postFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.synergy_project.ahomeproject.R;
import com.synergy_project.ahomeproject.main.MainActivity;
import com.shashank.sony.fancytoastlib.FancyToast;


public class ForAdoption extends AppCompatActivity {
    ImageView imgUpload_forAdpt_activity;
    Uri imgUploaded;
    Button btnList_forAdpt_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_adoption);
        imgUpload_forAdpt_activity = findViewById(R.id.imgUpload_forAdpt_activity);
        btnList_forAdpt_activity = findViewById(R.id.btnList_forAdpt_activity);

        int maxWidth = imgUpload_forAdpt_activity.getMaxWidth();
        int maxHeight = imgUpload_forAdpt_activity.getMaxHeight();
        FancyToast.makeText(getApplicationContext(), "width = " + maxWidth + "\n" + "height = " +
                maxHeight, FancyToast.LENGTH_LONG,
                FancyToast.SUCCESS, false).show();

        //getting image from postFragment

        Bundle extras = getIntent().getExtras();
        imgUploaded = Uri.parse(extras.getString("img_Upload"));
        imgUpload_forAdpt_activity.setImageURI(imgUploaded);

        //setting size of the imageView programmatically
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y/2;
        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,height);
        imgUpload_forAdpt_activity.setLayoutParams(parms);


//        FancyToast.makeText(getApplicationContext(), imgUploaded.getClass().getName().toLowerCase(), FancyToast.LENGTH_LONG,
//                FancyToast.SUCCESS,false).show();
    }

    public void goBack(View view) {
        startActivity(new Intent(ForAdoption.this, MainActivity.class));
    }

    public void createAListing(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}