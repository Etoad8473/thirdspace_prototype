package com.example.editprofileactivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.editprofileactivity.app.AppController;
import com.example.editprofileactivity.net_utils.Const;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText phoneNumber;
    private EditText name;
    private EditText gender;
    private EditText aboutMe;
    private EditText personality;
    private String FILE_NAME = "userInformation.json";
    //private String context = "/Users/kaiheng/Android-Team/1_cw_2/Experiments/Kai_Experiment/EditProfileActivity/app/src/test/java/com/example/editprofileactivity";

    private String TAG = MainActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    String msgResponse;
    private String tag_json_obj = "jobj_req";
    Random rand = new Random();
    long id = rand.nextLong();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button retrieveButton = (Button) findViewById(R.id.getDataButton);
        Button saveButton = (Button) findViewById(R.id.saveButton);
        email = (EditText) findViewById(R.id.editprofilewindows_email);
        phoneNumber = (EditText) findViewById(R.id.editprofilewindows_phoneNumber);
        name = (EditText) findViewById(R.id.editprofilewindows_name);
        gender = (EditText) findViewById(R.id.editprofilewindows_gender);
        aboutMe = (EditText) findViewById(R.id.editprofilewindows_aboutMe);
        personality = (EditText) findViewById(R.id.editprofilewindows_interest);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject jsonToString = new JSONObject();
                try {
                    writeElements(jsonToString);
                    writeToFile(view.getContext(), FILE_NAME, jsonToString);
                } catch (JSONException | IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        retrieveButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
/*
                File filename = new File(view.getContext().getFilesDir(), FILE_NAME);
                FileInputStream openFile;
                try {
                    openFile = new FileInputStream(filename);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                */



                /*
                System.out.println(v);
                try {
                    jsonString = IOUtils.toString(openFile,"UTF-8");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                */
                makeJsonObjReq();
                //startActivity(new Intent(MainActivity.this,JsonRequestActivity.class));
                /*
                JSONObject aJson;
                try {
                    URL url = new URL("https://e789ed85-a983-481b-88e9-739ad1ac0880.mock.pstmn.io/user/");
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(aJson);
                String jsonString = aJson.toString();
                getDataFromJson json = new Gson().fromJson(jsonString,getDataFromJson.class);
                email.setText(json.email);
                phoneNumber.setText(json.phone);
                name.setText(json.name);
                aboutMe.setText(json.aboutMe);
                personality.setText(json.personality);
                gender.setText(json.gender);
                */

            }
        });

    }



    public JSONObject writeElements(JSONObject obj) throws JSONException {
        obj.put("id", id);
        obj.put("email", email.getText());
        obj.put("phone", phoneNumber.getText());
        obj.put("name", name.getText());
        obj.put("gender", gender.getText());
        obj.put("aboutMe", aboutMe.getText());
        obj.put("personality", personality.getText());
        return obj;
    }
    public void writeToFile(Context context, String filename, JSONObject obj) throws IOException {
        String userString = obj.toString();
        // Define the File Path and its Name
        File file = new File(context.getFilesDir(),filename);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(userString);
        bufferedWriter.close();
    }

    public static String stream(URL url) {
        try (InputStream input = url.openStream()) {
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder json = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                json.append((char) c);
            }
            return json.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
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

    /**
     * Making json object request
     * */
    public void makeJsonObjReq() {
        showProgressDialog();
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                Const.URL_JSON_OBJECT, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                        msgResponse = response.toString();
                        System.out.println(msgResponse);
                        hideProgressDialog();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hideProgressDialog();
            }
        }) {

            /**
             * Passing some request headers
             * */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                return headers;
            }

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
//                params.put("name", "Androidhive");
//                params.put("email", "abc@androidhive.info");
//                params.put("pass", "password123");

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq,
                tag_json_obj);

        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
    }

}

class getDataFromJson{
    String name;
    String phone;
    String email;
    String aboutMe;
    String personality;
    String gender;

    public getDataFromJson(String n, String phone, String e, String aboutMe, String personality, String gender){
        this.name = n;
        this.phone = phone;
        this.email = e;
        this.aboutMe = aboutMe;
        this.personality = personality;
        this.gender = gender;
    }


}

class JsonReader{
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }


}