package com.example.sumon.androidvolley;

import static com.example.sumon.androidvolley.api.ApiClientFactory.GetGroupChatApi;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.sumon.androidvolley.api.SlimCallback;
import com.example.sumon.androidvolley.model.GroupChat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class GroupChatActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {
    private Button backButton;
    private TextView chatHistory, groupName;
    private ProgressDialog pDialog;
    private String tag_json_obj = "jobj_req", tag_json_arry = "jarray_req";
    private String TAG = GroupChatActivity.class.getSimpleName();

    private ScrollView chatHistoryScrollView;
    private EditText chatBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_chat);

        backButton = (Button) findViewById(R.id.GroupChatBackButton);
        chatBox = (EditText) findViewById(R.id.chatBox);
        chatHistory = (TextView) findViewById(R.id.chatHistory);
        groupName = (TextView) findViewById(R.id.groupNameTextView);
        chatHistoryScrollView = (ScrollView) findViewById(R.id.chatHistory_scrollView);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.setCancelable(false);

        backButton.setOnClickListener(this);
        chatBox.setOnKeyListener(this);
        RegenerateAllGroupChatOnScreen(chatHistory);

        final Handler handler = new Handler();
        Timer timer = new Timer();
        TimerTask chatList = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable(){
                    public void run(){
                        try{
                            RegenerateAllGroupChatOnScreen(chatHistory);
                            chatHistoryScrollView.fullScroll(View.FOCUS_DOWN);
                            chatBox.requestFocus();
                        }
                        catch(Exception e){

                        }
                    }
                });
            }
        };



        timer.schedule(chatList, 0, 300);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.GroupChatBackButton:
                finish();
                break;

            default:
                break;
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if ((event.getAction() == KeyEvent.ACTION_DOWN) &&(keyCode == KeyEvent.KEYCODE_ENTER))
        {
            chatHistory.append(chatBox.getText() + "\n");
            postChat();
            chatHistoryScrollView.fullScroll(View.FOCUS_DOWN);
            chatBox.getText().clear();
            chatBox.requestFocus();
            return true;
        }
        return false;
    }

    private void showProgressDialog() {
        if (!pDialog.isShowing())

            pDialog.show();
    }

    private void hideProgressDialog() {
        if (pDialog.isShowing())
            pDialog.hide();
    }

    public void RegenerateAllGroupChatOnScreen(TextView apiText1){

        GetGroupChatApi().GetAllGroupChat().enqueue(new SlimCallback<List<GroupChat>>(groupChats ->{
            apiText1.setText("");

            for (int i = 0; i < groupChats.size(); i++){
                apiText1.append(groupChats.get(i).printable());
            }
        }, "GetAllGroupChats"));
    }

    public void postChat(){
        GroupChat newChat = new GroupChat();
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
        //newChat.setGroupName(groupName.getText().toString());
        newChat.setSender(null);
        newChat.setTime(currentTime);
        newChat.setData(chatBox.getText().toString());
        newChat.setDate(currentDate);
        GetGroupChatApi().PostGroupChatByBody(newChat).enqueue(new SlimCallback<GroupChat>(groupChat->{
            RegenerateAllGroupChatOnScreen(chatHistory);
        }));
        /*GetPostApi().getFirstPost().enqueue(new SlimCallback<Post>(response -> {
            String result = "email:  "+ response.getEmail()
                    +"\n  phone:  "+ response.getPhoneNumber()
                    +"\n  name:  "+ response.getName()
                    +"\n  aboutMe:  "+ response.getAboutMe()
                    +"\n  personality:  "+ response.getPersonality()
                    +"\n  gender:  "+ response.getGender()
                    +"\n  Body:    "+ response.getBigText();
            System.out.println(result);
        }, "CustomTagForFirstApi"));

         */
    }

//    private void makeJsonArryReq() {
//        showProgressDialog();
//        JsonArrayRequest req = new JsonArrayRequest(Const.URL_JSON_ARRAY,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        Log.d(TAG, response.toString());
//                        //msgResponse.setText(response.toString());
//                        try {
//                            getJsonArrayData(response);
//                        } catch (JSONException e) {
//                            throw new RuntimeException(e);
//                        }
//                        hideProgressDialog();
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d(TAG, "Error: " + error.getMessage());
//                hideProgressDialog();
//            }
//        });
//
//        // Adding request to request queue
//        AppController.getInstance().addToRequestQueue(req,
//                tag_json_arry);
//
//        // Cancelling request
//        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_arry);
//    }
//
//    public void getJsonArrayData(JSONArray arr) throws JSONException {
//        String groupName = null, username_i = null, data_i = null, time_i = null, date_i = null;
//        String groupChatArr = null;
//        for(int i = 0; i< arr.length(); i++){
//            JSONObject obj = arr.getJSONObject(i);
//            groupChatArr = obj.getString("groupChat");
//            JSONObject groupChaObj = new JSONObject(groupChatArr);
//            JSONArray messagesArr = groupChaObj.getJSONArray("messages");
//            for(int j = 0; j<messagesArr.length(); j++){
//                JSONObject messagesObj = messagesArr.getJSONObject(j);
//                username_i = messagesObj.getString("username");
//                data_i = messagesObj.getString("data");
//                time_i = messagesObj.getString("time");
//                date_i = messagesObj.getString("date");
//            }
//            groupName = obj.getString("groupName");
//        }
//        user.setText((String) email_i);
//        phoneNumber.setText(phoneNumber_i);
//        name.setText(name_i);
//        aboutMe.setText(aboutMe_i);
//        username.setText(username_i);
//        personality.setText(hobby_i);
//        gender.setText(gender_i);
//    }
}