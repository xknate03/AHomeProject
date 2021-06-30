package com.synergy_project.ahomeproject.main.chatFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.synergy_project.ahomeproject.R;

import java.util.ArrayList;


public class ChatBox extends AppCompatActivity {
    TextView txtUsername_activity_chatBox,txtChatBody;
    EditText edtChatInput;
    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_box);

        txtUsername_activity_chatBox = findViewById(R.id.txtUsername_activity_chatBox);
        txtChatBody = findViewById(R.id.txtChatBody);
        edtChatInput = findViewById(R.id.edtChatInput);
        Bundle extras = getIntent().getExtras();
        userName = extras.getString("user_name");

        txtUsername_activity_chatBox.setText(userName);
    }

    public void sendChat(View view) {

        if(edtChatInput.getText() != null) {
            txtChatBody.setText(edtChatInput.getText());
        }

    }

    public void goBack(View view) {
                this.finish();
    }
}