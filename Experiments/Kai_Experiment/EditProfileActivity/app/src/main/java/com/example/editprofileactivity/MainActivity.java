package com.example.editprofileactivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.editprofileactivity.app.AppController;
import com.example.editprofileactivity.net_utils.Const;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.NameValuePair;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.ClientProtocolException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.HttpClient;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.entity.UrlEncodedFormEntity;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpPost;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client.DefaultHttpClient;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.BasicNameValuePair;
import com.google.gson.Gson;

import org.json.JSONArray;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    private TextView msgResponse;
    private String tag_json_obj = "jobj_req", tag_json_arry = "jarray_req";;


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

                startActivity(new Intent(MainActivity.this,JsonRequestActivity.class));

                JSONObject aJson = NULL;
                /*
                try {
                    URL url = new URL("https://e789ed85-a983-481b-88e9-739ad1ac0880.mock.pstmn.io/user/");
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(aJson);

                 */
                String jsonString = aJson.toString();
                getDataFromJson json = new Gson().fromJson(jsonString,getDataFromJson.class);
                email.setText(json.email);
                phoneNumber.setText(json.phone);
                name.setText(json.name);
                aboutMe.setText(json.aboutMe);
                personality.setText(json.personality);
                gender.setText(json.gender);


            }
        });

    }



    public JSONObject writeElements(JSONObject obj) throws JSONException {
        obj.put("email", email.getText());
        obj.put("phoneNumber", phoneNumber.getText());
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
                        msgResponse.setText(response.toString());
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
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);

        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
    }

    /**
     * Making json array request
     * */
    private void makeJsonArryReq() {
        showProgressDialog();
        JsonArrayRequest req = new JsonArrayRequest(Const.URL_JSON_ARRAY,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        msgResponse.setText(response.toString());
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

    public void postData() {
        // Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://coms-309-015.class.las.iastate.edu:8080/users");

        try {
            // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("email", "random@random.com"));
            nameValuePairs.add(new BasicNameValuePair("name", "random"));
            nameValuePairs.add(new BasicNameValuePair("userName", "thisisrandomusername"));
            nameValuePairs.add(new BasicNameValuePair("password", "helloworld"));
            nameValuePairs.add(new BasicNameValuePair("gender", "male"));
            nameValuePairs.add(new BasicNameValuePair("phoneNumber", "5156666777"));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
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