package com.synergy_project.ahomeproject.main.chatFragment;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.synergy_project.ahomeproject.R;
import java.util.ArrayList;

public class ChatList extends AppCompatActivity {
    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<String> array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_chat_list);

        listView = findViewById(R.id.my_listView);
         array = new ArrayList<>();

        array.add("Liam");
        array.add("Noah");
        array.add("Oliver");
        array.add("Elijah");
        array.add("William");
        array.add("James");
        array.add("Sophia");
        array.add("Isabella");

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, array);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(ChatList.this, "Clicked Item"+array.get(position).toString(), Toast.LENGTH_SHORT).show();
            openActivity(position);
        });
    }

    private void openActivity(int position) {
        Intent intent = new Intent(this, ChatBox.class);
        intent.putExtra("user_name", array.get(position));
        startActivity(intent);
    }

    public void goBack(View view) {
        this.finish();
    }
}