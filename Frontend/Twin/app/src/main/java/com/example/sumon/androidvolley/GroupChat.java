package com.example.sumon.androidvolley;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GroupChat extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {
    private Button backButton;
    private EditText chatBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_chat);

        backButton = (Button) findViewById(R.id.backButton);
        chatBox = (EditText) findViewById(R.id.chatBox);

        backButton.setOnClickListener(this);
        chatBox.setOnKeyListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.backButton:
                finish();
                break;

            default:
                break;
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER))
        {
            Toast.makeText(GroupChat.this,chatBox.getText(), Toast.LENGTH_LONG).show();
            chatBox.getText().clear();
            return true;
        }
        return false;
    }
}