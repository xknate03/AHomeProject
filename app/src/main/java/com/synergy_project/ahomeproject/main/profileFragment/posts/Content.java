package com.synergy_project.ahomeproject.main.profileFragment.posts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.synergy_project.ahomeproject.R;

public class Content extends AppCompatActivity {
    TextView txtTitle_content, txtDesc_content;
    ImageView img_content;

    String title, desc;
    String line;
    String entireFile;

    int image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        txtTitle_content = findViewById(R.id.txtTitle_content);
        txtDesc_content = findViewById(R.id.txtDesc_content);
        img_content = findViewById(R.id.img_content);
//getting data
        getData();
        setData();
    }

    private void getData() {
        if( getIntent().hasExtra("title") && getIntent().hasExtra("desc") && getIntent().hasExtra("imgImage")) {
            title = getIntent().getStringExtra("title");
            desc = getIntent().getStringExtra("desc");
            image = getIntent().getIntExtra("imgImage", 1);
        }else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        txtTitle_content.setText(title);
        txtDesc_content.setText(desc);
        img_content.setImageResource(image);
    }
}