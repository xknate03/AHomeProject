package com.calculator.ahomeproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        listView = findViewById(R.id.my_listView);

        ArrayList<String> array = new ArrayList<>();


        array.add("Username1");
        array.add("Username2");
        array.add("Username3");
        array.add("Username4");
        array.add("Username5");
        array.add("Username6");
        array.add("Username7");
        array.add("Username8");



        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, array);

        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ChatActivity.this, "Clicked Item"+array.get(position).toString(), Toast.LENGTH_SHORT).show();
                openActivity();
            }
        });



    }

    private void openActivity() {
        Intent intent = new Intent(this, ChatActivity2.class);
        startActivity(intent);
    }


}