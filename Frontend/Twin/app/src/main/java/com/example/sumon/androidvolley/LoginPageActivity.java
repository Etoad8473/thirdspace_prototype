package com.example.sumon.androidvolley;

import static com.example.sumon.androidvolley.api.ApiClientFactory.GetLoginApi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sumon.androidvolley.api.SlimCallback;
import com.example.sumon.androidvolley.model.Login;
import com.example.sumon.androidvolley.utils.Const;

public class LoginPageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginBtn, signUpBtn;
    private EditText usernameText, passwordText;
    private TextView loginDetailsCheck;
    protected String getLoginUsername = "";
    protected String getLoginPassword = "";
    private boolean userLoginDetails;
    private ProgressDialog pDialog;
    private String TAG = LoginPageActivity.class.getSimpleName();
    private String tag_json_obj = "jobj_req", tag_json_arry = "jarray_req";
    protected String userLoginUrl = "";
    private String stringUserId = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        loginBtn = (Button) findViewById(R.id.loginButton);
        signUpBtn = (Button) findViewById(R.id.signUpButton);
        usernameText = (EditText) findViewById(R.id.usernameInputText);
        passwordText = (EditText) findViewById(R.id.passwordInputText);
        loginDetailsCheck = (TextView) findViewById(R.id.loginDetailsWrongHint);

        userLoginDetails = false;

        loginDetailsCheck.setVisibility(View.INVISIBLE);

        loginBtn.setOnClickListener(this);
        signUpBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.loginButton:
                checkLogins();
                loginDetailsCheck.setText("Login Successful");
                loginDetailsCheck.setTextColor(Color.parseColor("#00CC66"));
                loginDetailsCheck.setVisibility(View.VISIBLE);

                break;

            case R.id.signUpButton:
                startActivity(new Intent(LoginPageActivity.this, SignUpPageActivity.class));
                break;

            default:
                break;
        }
    }

//    public void postLoginRequest() {
//        GetLoginApi().PostLoginRequest(usernameText.getText().toString(), passwordText.getText().toString()).
//                enqueue(new SlimCallback<Login>(login->{
//        }));
//    }
    void checkLogins(){
        GetLoginApi().GetLoginCheck(usernameText.getText().toString(), passwordText.getText().toString()).enqueue(new SlimCallback<Login>(login ->{
            stringUserId = Integer.toString(login.getId());
            Const.USER_ID = Integer.parseInt(stringUserId);
//            loginDetailsCheck.setText(stringUserId);
            userLoginDetails = true;

            if(userLoginDetails){
                loginDetailsCheck.setVisibility(View.INVISIBLE);
                //loginDetailsCheck.setText(Integer.toString(Const.USER_ID));
                finish();
            }
        }, "GetLoginDetails"));

}


    private void showProgressDialog() {
        if (!pDialog.isShowing())

            pDialog.show();
    }

    private void hideProgressDialog() {
        if (pDialog.isShowing())
            pDialog.hide();
    }
}