package com.example.twin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;

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
import java.util.Map;


public class ChooseHobby extends AppCompatActivity {
    ListView listViewData;
    String hobbyN;
    Button btn;
    //ArrayAdapter<String> adapter;
    //String[] array_hobby={};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_hobby);

        //listViewData = findViewById(R.id.hobbylist);

        //adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, array_hobby);
        //listViewData.setAdapter(adapter);

        TextInputLayout text = findViewById(R.id.hobby);
        hobbyN = text.getEditText().getText().toString();
        postData(hobbyN);

    }

    private void postData(String hobbyN) {

        String url = " http://coms-309-015.class.las.iastate.edu:8080/";
        RequestQueue queue = Volley.newRequestQueue(ChooseHobby.this);
        JSONObject obj = new JSONObject();

        try {

          obj.put("hobbyN", hobbyN);


        } catch(Exception e) {

            System.out.println("ERROR");

        }

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST, url, obj,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Intent intent = new Intent(ChooseHobby.this, MainActivity.class);
                        startActivity(intent);
                        finish();



                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        if (error instanceof ServerError) {
                            Toast.makeText(ChooseHobby.this, "Server", Toast.LENGTH_SHORT).show();
                        } else if (error instanceof NetworkError) {
                            Toast.makeText(ChooseHobby.this, "Network", Toast.LENGTH_SHORT).show();
                            System.out.println(error.getMessage());

                        } else if (error instanceof AuthFailureError) {
                            Toast.makeText(ChooseHobby.this, "Auth", Toast.LENGTH_SHORT).show();
                        } else if (error instanceof ParseError) {
                            Toast.makeText(ChooseHobby.this, "Parse", Toast.LENGTH_SHORT).show();
                        } else if (error instanceof NoConnectionError) {
                            Toast.makeText(ChooseHobby.this, "No Connection", Toast.LENGTH_SHORT).show();
                        } else if (error instanceof TimeoutError) {
                            Toast.makeText(ChooseHobby.this, "T/O", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ChooseHobby.this, "Unknown", Toast.LENGTH_SHORT).show();

                        }

                    }
                }){

        };


    }

/**
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int hb = item.getItemId();
        if(hb == R.id.hobby_chosen){
            String choosenHobby = "Selected hobby: \n";

            for(int i = 0; i<listViewData.getCount();i++){
                if(listViewData.isItemChecked(i)){

                    choosenHobby += listViewData.getItemAtPosition(i) + "\n";

                }

            }
            Toast.makeText(this, choosenHobby, Toast.LENGTH_SHORT).show();

        }

        return super.onOptionsItemSelected(item);

    }
**/
}