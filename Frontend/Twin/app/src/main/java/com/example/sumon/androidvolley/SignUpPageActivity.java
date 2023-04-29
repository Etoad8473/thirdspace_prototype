package com.example.sumon.androidvolley;

import static com.example.sumon.androidvolley.api.ApiClientFactory.GetSignUpApi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.sumon.androidvolley.api.SlimCallback;
import com.example.sumon.androidvolley.app.AppController;
import com.example.sumon.androidvolley.model.SignUp;
import com.example.sumon.androidvolley.utils.Const;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SignUpPageActivity extends AppCompatActivity implements View.OnClickListener {
    private ProgressDialog pDialog;
    private String TAG = SignUpPageActivity.class.getSimpleName();
    private String tag_json_obj = "jobj_req", tag_json_arry = "jarray_req";
    private Button createUserBtn;
    private EditText usernameEditText, emailAdrrEditText, passwordEditText;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);

        createUserBtn = (Button) findViewById(R.id.createUserButton);
        usernameEditText = (EditText) findViewById(R.id.newUsernameInputText);
        emailAdrrEditText = (EditText) findViewById(R.id.emailAddrInputText);
        passwordEditText = (EditText) findViewById(R.id.newPasswordInputText);

        userId = 0;

        createUserBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.createUserButton:
                postObj();
                makeJsonArryReq();
                Const.USER_ID = userId;
                finish();
                startActivity(new Intent(SignUpPageActivity.this, PersonalityBuilder.class));
        }
    }

    private void showProgressDialog() {
        if (!pDialog.isShowing())

            pDialog.show();
    }

    private void hideProgressDialog() {
        if (pDialog.isShowing())
            pDialog.hide();
    }

    public void postObj(){
        SignUp newUser = new SignUp();
        newUser.setEmail(emailAdrrEditText.getText().toString());
        newUser.setPassword(passwordEditText.getText().toString());
        newUser.setUserName(usernameEditText.getText().toString());
        GetSignUpApi().PostNewUser(newUser).enqueue(new SlimCallback<SignUp>(newUsers->{
        }));
    }

    /**
     * Making json array request
     * */
    public void makeJsonArryReq() {
        showProgressDialog();
        JsonArrayRequest req = new JsonArrayRequest(Const.URL_JSON_ARRAY,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        //msgResponse.setText(response.toString());
                        try {
                            getJsonArrayData(response);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                        hideProgressDialog();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hideProgressDialog();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(req,
                tag_json_arry);

        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_arry);
    }

    public void getJsonArrayData(JSONArray arr) throws JSONException {
        int id_i = 0;
        String email_i = null, phoneNumber_i = null, name_i = null, aboutMe_i = null, gender_i = null,
                username_i = null, hobby_i = null;
        String personalityArr = null;
        for(int i = 0; i< arr.length(); i++){
            JSONObject obj = arr.getJSONObject(i);
            id_i = obj.getInt("id");
            personalityArr = obj.getString("personality");
            JSONObject personalityObj = new JSONObject(personalityArr);
            JSONArray hobbyArr = personalityObj.getJSONArray("hobbies");
            for(int j = 0; j<hobbyArr.length(); j++){
                JSONObject hobbyObj = hobbyArr.getJSONObject(j);
                hobby_i = hobby_i + hobbyObj.getString("hobbyN") + ",";
            }
            email_i = obj.getString("email");
            phoneNumber_i = obj.getString("phoneNumber");
            name_i = obj.getString("name");
            //aboutMe_i = obj.getString("aboutMe");
            username_i = obj.getString("userName");
            if(username_i == String.valueOf(usernameEditText.getText())){
                userId = id_i;
            }
            gender_i = obj.getString("gender");
        }

    }
}