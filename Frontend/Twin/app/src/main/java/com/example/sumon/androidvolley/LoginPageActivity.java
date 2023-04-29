package com.example.sumon.androidvolley;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginPageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginBtn, signUpBtn;
    private EditText usernameText, passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        loginBtn = (Button) findViewById(R.id.loginButton);
        signUpBtn = (Button) findViewById(R.id.signUpButton);
        usernameText = (EditText) findViewById(R.id.usernameInputText);
        passwordText = (EditText) findViewById(R.id.passwordInputText);

        loginBtn.setOnClickListener(this);
        signUpBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.loginButton:
                break;

            case R.id.signUpButton:
                startActivity(new Intent(LoginPageActivity.this, SignUpPageActivity.class));
                break;

            default:
                break;
        }

    }
}