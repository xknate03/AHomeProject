package com.calculator.ahomeproject.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.calculator.ahomeproject.R;
import com.calculator.ahomeproject.login.LoginActivity;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edtEmailSignup, edtFullNameSignup, edtUsernameSignup, edtPasswordSignup, edtRetypePasswordSignup;
    Button btnSignUpSignUp, btnLoginSignUp;
    SignUpModel signUpModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUpModel = new SignUpModel();
        edtFullNameSignup = findViewById(R.id.edtFullNameSignup);
        edtEmailSignup = findViewById(R.id.edtEmailSignup);
        edtUsernameSignup = findViewById(R.id.edtUsernameSignup);
        edtPasswordSignup = findViewById(R.id.edtPasswordSignup);
        edtRetypePasswordSignup = findViewById(R.id.edtRetypePasswordSignup);
        btnSignUpSignUp = findViewById(R.id.btnSignUpSignUp);
        btnLoginSignUp = findViewById(R.id.btnLoginSignUp);

        btnSignUpSignUp.setOnClickListener(this);
        btnLoginSignUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnSignUpSignUp:
                boolean isMatching = signUpModel.isMatching(edtPasswordSignup.getText().toString(), edtRetypePasswordSignup.getText().toString());
                boolean isPasswordValid = signUpModel.isPasswordValid(edtPasswordSignup.getText().toString());
                FancyToast.makeText(SignUpActivity.this, "matching: " + isMatching + " , valid: " + isPasswordValid,
                        FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show();
                if(isMatching && isPasswordValid) {

                    ParseUser user = new ParseUser();
                    ParseObject profile = new ParseObject("Profile");
                    // Set the user's username and password, which can be obtained by a forms
                    profile.put("full_name", edtFullNameSignup.getText().toString());
                    profile.put("email", edtEmailSignup.getText().toString());
                    profile.put("user_name", edtUsernameSignup.getText().toString());
                    profile.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e != null) {
                                FancyToast.makeText(SignUpActivity.this, "Profile not saved",
                                        FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
                            }
                        }
                    });
                    user.setEmail(edtEmailSignup.getText().toString());
                    user.setUsername(edtUsernameSignup.getText().toString());
                    user.setPassword(edtPasswordSignup.getText().toString());

                    user.signUpInBackground(e -> {
                        if (e == null) {
                            FancyToast.makeText(SignUpActivity.this, "Welcome ",
                                    FancyToast.LENGTH_LONG, FancyToast.SUCCESS, false).show();
                        } else {
                            ParseUser.logOut();
                            FancyToast.makeText(SignUpActivity.this, e.getMessage(),
                                    FancyToast.LENGTH_LONG, FancyToast.ERROR, false).show();
                        }
                    });
                }
                break;




            case R.id.btnLoginSignUp:
                transitionToLogin();
                break;
        }
    }


    public void transitionToLogin() {
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void rootLayoutTapped(View view) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


}