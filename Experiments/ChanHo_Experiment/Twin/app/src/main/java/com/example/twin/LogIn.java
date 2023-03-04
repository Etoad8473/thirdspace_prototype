package com.example.twin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LogIn extends AppCompatActivity {

    TextView txtSignUp;
    Button button;

    String username;
    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        txtSignUp = findViewById(R.id.txtSignUp);

        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this, SignUp.class);
                startActivity(intent);
                finish();
            }
        });

        button = findViewById(R.id.btnlogin);
        TextInputLayout text = findViewById(R.id.username);
        username = text.getEditText().getText().toString();
        text = findViewById(R.id.password);
        password = text.getEditText().getText().toString();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                postData(username, password);


            }
        });
    }


    private void postData(String username, String password) {

        String url = " http://coms-309-015.class.las.iastate.edu:8080/";
        RequestQueue queue = Volley.newRequestQueue(LogIn.this);
        JSONObject obj = new JSONObject();

        try {

            obj.put("username", username);
            obj.put("password", password);


        } catch (Exception e) {

            System.out.println("ERROR");

        }


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, obj,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            if(response.getBoolean("result")) {
                                Toast.makeText(LogIn.this, "Log In Successful!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LogIn.this, ChooseHobby.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(LogIn.this, "Log In Failed...", Toast.LENGTH_SHORT).show();
                            }


                        }catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof ServerError) {
                    Toast.makeText(LogIn.this, "Server", Toast.LENGTH_SHORT).show();
                } else if (error instanceof NetworkError) {
                    Toast.makeText(LogIn.this, "Network", Toast.LENGTH_SHORT).show();
                    System.out.println(error.getMessage());

                } else if (error instanceof AuthFailureError) {
                    Toast.makeText(LogIn.this, "Auth", Toast.LENGTH_SHORT).show();
                } else if (error instanceof ParseError) {
                    Toast.makeText(LogIn.this, "Parse", Toast.LENGTH_SHORT).show();
                } else if (error instanceof NoConnectionError) {
                    Toast.makeText(LogIn.this, "No Connection", Toast.LENGTH_SHORT).show();
                } else if (error instanceof TimeoutError) {
                    Toast.makeText(LogIn.this, "T/O", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LogIn.this, "Unknown", Toast.LENGTH_SHORT).show();

                }

            }
        }){
            @Override
            public Map<String, String> getParams() {

                Map<String, String> p = new HashMap<String, String>();

                p.put("username", username);


                p.put("password", password);

                return p;

            }

        };
        queue.add(jsonObjReq);


    }

    /**
    public void getData(String username, String password){
        String url = " http://coms-309-015.class.las.iastate.edu:8080/";
        RequestQueue queue = Volley.newRequestQueue(LogIn.this);
        JSONObject obj = new JSONObject();

        try {

            obj.put("username", username);
            obj.put("password", password);


        } catch (Exception e) {

            System.out.println("ERROR");

        }

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url, obj,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            if(response.getBoolean("result")) {
                                Toast.makeText(LogIn.this, "Log In Successful!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(LogIn.this, "Log In Failed...", Toast.LENGTH_SHORT).show();
                            }


                        }catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof ServerError) {
                    Toast.makeText(LogIn.this, "Server", Toast.LENGTH_SHORT).show();
                } else if (error instanceof NetworkError) {
                    Toast.makeText(LogIn.this, "Network", Toast.LENGTH_SHORT).show();
                    System.out.println(error.getMessage());

                } else if (error instanceof AuthFailureError) {
                    Toast.makeText(LogIn.this, "Auth", Toast.LENGTH_SHORT).show();
                } else if (error instanceof ParseError) {
                    Toast.makeText(LogIn.this, "Parse", Toast.LENGTH_SHORT).show();
                } else if (error instanceof NoConnectionError) {
                    Toast.makeText(LogIn.this, "No Connection", Toast.LENGTH_SHORT).show();
                } else if (error instanceof TimeoutError) {
                    Toast.makeText(LogIn.this, "T/O", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LogIn.this, "Unknown", Toast.LENGTH_SHORT).show();

                }


            }
        }){

        };

    }**/
}