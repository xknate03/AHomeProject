package com.synergy_project.ahomeproject.login;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.synergy_project.ahomeproject.R;
import com.synergy_project.ahomeproject.main.MainActivity;
import com.synergy_project.ahomeproject.signup.SignUpActivity;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnLoginLogin;
    EditText edtEmailLogin, edtPasswordLogin;
    TextView txtRegisterLogin;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading");
        txtRegisterLogin = findViewById(R.id.txtRegisterLogin);
        edtEmailLogin = findViewById(R.id.edtEmailLogin);
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin);
        btnLoginLogin = findViewById(R.id.btnLoginLogin);

        btnLoginLogin.setOnClickListener(this);
        txtRegisterLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnLoginLogin:
                String email = edtEmailLogin.getText().toString();
                String password = edtPasswordLogin.getText().toString();
                login(email, password);
                break;
            case R.id.txtRegisterLogin:
                transitionToSignUpActivity();
                break;
        }
    }

    private void login(String email, String password) {
        progressDialog.show();
        ParseUser.logInInBackground(email, password, (parseUser, e) -> {
            progressDialog.dismiss();
            if (parseUser != null) {
                FancyToast.makeText(LoginActivity.this,"Welcome back " +
                        ParseUser.getCurrentUser().getUsername() + "! ", FancyToast.LENGTH_LONG,
                        FancyToast.SUCCESS,false).show();
                transitionToHome();
            } else {
                ParseUser.logOut();
                FancyToast.makeText(LoginActivity.this,e.getMessage(),
                        FancyToast.LENGTH_LONG,FancyToast.ERROR,false).show();
            }
        });
    }

    public void transitionToSignUpActivity() {
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

    public void transitionToHome() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}