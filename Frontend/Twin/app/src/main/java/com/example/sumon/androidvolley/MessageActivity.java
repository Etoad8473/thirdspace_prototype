package com.example.sumon.androidvolley;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.sumon.androidvolley.utils.Const;
import com.example.sumon.androidvolley.webSocket.WebSocketListener;
import com.example.sumon.androidvolley.webSocket.WebSocketManager;

public class MessageActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener, WebSocketListener {

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
        setContentView(R.layout.activity_message);

        String serverUrl = "http://coms-309-015.class.las.iastate.edu:8080/groupChat" + Integer.toString(Const.USER_ID);

        Log.d("Socket:", "Trying socket");
        WebSocketManager.getInstance().connect(serverUrl);
        WebSocketManager.getInstance().setWebSocketListener(MessageActivity.this);

        backButton = (Button) findViewById(R.id.messageBackButton);
        chatBox = (EditText) findViewById(R.id.messageBox);
        chatHistory = (TextView) findViewById(R.id.messageHistory);
        groupName = (TextView) findViewById(R.id.messageNameTextView);
        chatHistoryScrollView = (ScrollView) findViewById(R.id.messageHistory_scrollView);

//        pDialog = new ProgressDialog(this);
//        pDialog.setMessage("Loading...");
//        pDialog.setCancelable(false);

        backButton.setOnClickListener(this);
        chatBox.setOnKeyListener(this);
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
//            chatHistory.append(chatBox.getText() + "\n");
//            postChat();
            WebSocketManager.getInstance().sendMessage(chatBox.getText().toString());
            chatHistoryScrollView.fullScroll(View.FOCUS_DOWN);
            chatBox.getText().clear();
            chatBox.requestFocus();
            return true;
        }
        return false;
    }


    @Override
    public void onWebSocketMessage(String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d("","run() returned: " + message);
                String s = chatHistory.getText().toString();
                chatHistory.setText(s+ "\n" + message);
            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        WebSocketManager.getInstance().removeWebSocketListener();
    }
}