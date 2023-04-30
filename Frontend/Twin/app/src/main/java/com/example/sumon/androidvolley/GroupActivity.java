package com.example.sumon.androidvolley;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class GroupActivity extends AppCompatActivity implements View.OnClickListener {
    private Button group1Btn;
    private LinearLayout groupLinearLay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        group1Btn = (Button) findViewById(R.id.groupBtn1);
        groupLinearLay = (LinearLayout) findViewById(R.id.groupLinearLayout);

        group1Btn.setOnClickListener(this);

        for(int i = 0; i< 20; i++) {
            Button groupButton = new Button(this);
            groupButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            groupButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
            groupButton.setText("Hello");
            groupButton.setTextColor(Color.parseColor("#FFFFFFFF"));
            groupButton.setBackgroundColor(Color.parseColor("#FF6200EE"));
            groupButton.setOnClickListener(this);
            groupButton.setId(1000+i);

            groupLinearLay.addView(groupButton);
        }

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

        }
    }
}