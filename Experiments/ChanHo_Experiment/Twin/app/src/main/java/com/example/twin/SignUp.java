package com.example.twin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class SignUp extends AppCompatActivity {

    TextView txtSignIn;
    Button button;
    String name;
    String username;
    String password;
    String c_password;
    String email;
    String phoneNumber;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        txtSignIn = findViewById(R.id.txtSignIn);

        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, LogIn.class);
                startActivity(intent);

            }
        });

        button = (Button) findViewById(R.id.btnsignup);

        TextInputLayout text = findViewById(R.id.name);
        name = text.getEditText().getText().toString();

        text = findViewById(R.id.username);
        username = text.getEditText().getText().toString();
        text = findViewById(R.id.email);
        email = text.getEditText().getText().toString();
        text = findViewById(R.id.mobile);
        phoneNumber = text.getEditText().getText().toString();
        text = findViewById(R.id.password);
        password = text.getEditText().getText().toString();
        text = findViewById(R.id.confirmPasswrd);
        c_password = text.getEditText().getText().toString();
        text = findViewById(R.id.gender);
        gender = text.getEditText().getText().toString();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, LogIn.class);
                //password doesn't match
                if(!password.equals(c_password)){
                    Toast.makeText(SignUp.this, "Password doesn't match", Toast.LENGTH_SHORT).show();
                    finish();
                //Later, I have to add the statement
                //to figure if the user has already been on our data
                }else if(!(gender.toUpperCase(Locale.ROOT).equals("MALE")) || !(gender.toUpperCase(Locale.ROOT).equals("FEMALE"))){
                    Toast.makeText(SignUp.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    finish();

                }
                postData(email,name,username,password,gender, phoneNumber);
                startActivity(intent);
                finish();



            }
        });


    }


    private void postData(String email, String name, String username, String password, String gender, String phoneNumber) {

        String url = "http://coms-309-015.class.las.iastate.edu:8080/users";
        RequestQueue queue = Volley.newRequestQueue(SignUp.this);
        JSONObject obj = new JSONObject();

        try {
            obj.put("email", email);
            obj.put("name", name);
            obj.put("userName", username);
            obj.put("password", password);
            obj.put("gender", gender);
            obj.put("phoneNumber", phoneNumber);



        } catch(Exception e) {

            System.out.println("ERROR");

        }



            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, obj,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Toast.makeText(SignUp.this, "Welcome!", Toast.LENGTH_LONG).show();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    if (error instanceof ServerError) {
                        Toast.makeText(SignUp.this, "Server", Toast.LENGTH_SHORT).show();
                    } else if (error instanceof NetworkError) {
                        Toast.makeText(SignUp.this, "Network", Toast.LENGTH_SHORT).show();
                        System.out.println(error.getMessage());

                    } else if (error instanceof AuthFailureError) {
                        Toast.makeText(SignUp.this, "Auth", Toast.LENGTH_SHORT).show();
                    } else if (error instanceof ParseError) {
                        Toast.makeText(SignUp.this, "Parse", Toast.LENGTH_SHORT).show();
                    } else if (error instanceof NoConnectionError) {
                        Toast.makeText(SignUp.this, "No Connection", Toast.LENGTH_SHORT).show();
                    } else if (error instanceof TimeoutError) {
                        Toast.makeText(SignUp.this, "T/O", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SignUp.this, "Unknown", Toast.LENGTH_SHORT).show();

                    }
                }
            }) {

                @Override
                public Map<String, String> getParams() {

                    Map<String, String> p = new HashMap<String, String>();
                    p.put("name", name);
                    p.put("username", username);
                    p.put("email", email);
                    p.put("phoneNumber", phoneNumber);
                    p.put("password", password);
                    p.put("gender", gender);
                    return p;

                }

            };

            queue.add(jsonObjReq);


        }

}