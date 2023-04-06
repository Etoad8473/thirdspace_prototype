package com.example.sumon.androidvolley;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class PersonalityBuilder extends AppCompatActivity implements View.OnClickListener {
    private Button basketballBtn, soccerBtn, doneBtn;
    private TextView selectedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personality_builder);

        basketballBtn = (Button) findViewById(R.id.basketballHobbiesButton);
        soccerBtn = (Button) findViewById(R.id.soccerHobbiesButton);
        doneBtn = (Button) findViewById(R.id.personalityDoneButton);
        selectedView = (TextView) findViewById(R.id.viewSelected);

        basketballBtn.setOnClickListener(this);
        soccerBtn.setOnClickListener(this);
        doneBtn.setOnClickListener(this);

        final Handler handler = new Handler();
        Timer timer = new Timer();
        TimerTask updateList = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable(){
                    public void run(){
                        try{
                            checkSelected(selectedView);
                        }
                        catch(Exception e){

                        }
                    }
                });
            }
        };

        timer.schedule(updateList, 0, 100);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.personalityDoneButton:
                finish();
                break;

            case R.id.basketballHobbiesButton:
                if(basketballBtn.isSelected() == false){
                    basketballBtn.setSelected(true);
                    basketballBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(basketballBtn.isSelected() == true){
                    basketballBtn.setSelected(false);
                    basketballBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }

                break;

            case R.id.soccerHobbiesButton:
                if(soccerBtn.isSelected() == false){
                    soccerBtn.setSelected(true);
                    soccerBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(soccerBtn.isSelected() == true) {
                    soccerBtn.setSelected(false);
                    soccerBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }

                break;

            default:
                break;

        }
    }

    public void checkSelected(TextView hobbiesView){
        hobbiesView.setText("");
        if(soccerBtn.isSelected() == true){
            hobbiesView.append(soccerBtn.getText() + " | ");
        }

        if(basketballBtn.isSelected() == true){
            hobbiesView.append(basketballBtn.getText() + " | ");
        }
    }
}