package com.example.editprofileactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText phoneNumber;
    private EditText name;
    private EditText gender;
    private EditText aboutMe;
    private EditText personality;
    private String FILE_NAME = "userInformation.json";
    private String context = "/Users/kaiheng/Android-Team/1_cw_2/Experiments/Kai_Experiment/EditProfileActivity/app/src/test/java/com/example/editprofileactivity";


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

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject jsonToString = new JSONObject();
                try {
                    createJson(jsonToString);
                    // Convert JsonObject to String Format
                    String userString = jsonToString.toString();
                    // Define the File Path and its Name
                    File file = new File(context,FILE_NAME);
                    FileWriter fileWriter = new FileWriter(file);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(userString);
                    bufferedWriter.close();
                } catch (JSONException | IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    public JSONObject createJson(JSONObject obj) throws JSONException {
        Random rand = new Random();
        long id = rand.nextLong();
        obj.put("id", id);
        obj.put("email", email);
        obj.put("phone", phoneNumber);
        obj.put("name", name);
        obj.put("gender", gender);
        obj.put("aboutMe", aboutMe);
        obj.put("personality", personality);
        return obj;
    }


}