package com.example.sumon.androidvolley;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class GroupChat extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {
    private Button backButton;
    private TextView chatHistory;

    private ScrollView chatHistoryScrollView;
    private EditText chatBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_chat);

        backButton = (Button) findViewById(R.id.GroupChatBackButton);
        chatBox = (EditText) findViewById(R.id.chatBox);
        chatHistory = (TextView) findViewById(R.id.chatHistory);
        chatHistoryScrollView = (ScrollView) findViewById(R.id.chatHistory_scrollView);

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
            chatHistory.append(chatBox.getText() + "\n");
            chatHistoryScrollView.fullScroll(View.FOCUS_DOWN);
            chatBox.getText().clear();
            chatBox.requestFocus();
            return true;
        }
        return false;
    }
}