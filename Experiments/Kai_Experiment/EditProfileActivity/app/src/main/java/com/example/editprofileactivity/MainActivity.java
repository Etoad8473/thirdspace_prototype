package com.example.editprofileactivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    //private String context = "/Users/kaiheng/Android-Team/1_cw_2/Experiments/Kai_Experiment/EditProfileActivity/app/src/test/java/com/example/editprofileactivity";

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
                File filename = new File(view.getContext().getFilesDir(), FILE_NAME);
                FileInputStream openFile;
                try {
                    openFile = new FileInputStream(filename);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                String jsonString = null;
                try {
                    jsonString = IOUtils.toString(openFile, "UTF-8");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

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