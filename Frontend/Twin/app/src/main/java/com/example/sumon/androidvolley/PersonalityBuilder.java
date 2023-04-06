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
    private Button sportsBtn, bikingBtn, gardeningBtn, bakingBtn, archeryBtn, singingBtn, bloggingBtn, bowlingBtn,
            photographyBtn, cookingBtn, readingBtn, travelBtn, artBtn, potteryBtn, hikingBtn, fishingBtn,
            paintingBtn, danceBtn, musicBtn, woodworkingBtn, yogaBtn, calligraphyBtn, chessBtn, knittingBtn, doneBtn;
    private TextView selectedView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personality_builder);

        sportsBtn = (Button) findViewById(R.id.sportsHobbiesButton);
        bikingBtn = (Button) findViewById(R.id.bikingHobbiesButton);
        gardeningBtn = (Button) findViewById(R.id.gardeningHobbiesButton);
        bakingBtn = (Button) findViewById(R.id.bakingHobbiesButton);
        archeryBtn = (Button) findViewById(R.id.archeryHobbiesButton);
        singingBtn = (Button) findViewById(R.id.singingHobbiesButton);
        bloggingBtn = (Button) findViewById(R.id.bloggingHobbiesButton);
        bowlingBtn = (Button) findViewById(R.id.bowlingHobbiesButton);
        photographyBtn = (Button) findViewById(R.id.photographyHobbiesButton);
        cookingBtn = (Button) findViewById(R.id.cookingHobbiesButton);
        readingBtn = (Button) findViewById(R.id.readingHobbiesButton);
        travelBtn = (Button) findViewById(R.id.travelHobbiesButton);
        artBtn = (Button) findViewById(R.id.artHobbiesButton);
        potteryBtn = (Button) findViewById(R.id.potteryHobbiesButton);
        hikingBtn = (Button) findViewById(R.id.hikingHobbiesButton);
        fishingBtn = (Button) findViewById(R.id.fishingHobbiesButton);
        paintingBtn = (Button) findViewById(R.id.paintingHobbiesButton);
        danceBtn = (Button) findViewById(R.id.danceHobbiesButton);
        musicBtn = (Button) findViewById(R.id.musicHobbiesButton);
        woodworkingBtn = (Button) findViewById(R.id.woodworkingHobbiesButton);
        yogaBtn = (Button) findViewById(R.id.yogaHobbiesButton);
        calligraphyBtn = (Button) findViewById(R.id.calligraphyHobbiesButton);
        chessBtn = (Button) findViewById(R.id.chessHobbiesButton);
        knittingBtn = (Button) findViewById(R.id.knittingHobbiesButton);

        doneBtn = (Button) findViewById(R.id.personalityDoneButton);
        selectedView = (TextView) findViewById(R.id.viewSelected);

        sportsBtn.setOnClickListener(this);
        bikingBtn.setOnClickListener(this);
        gardeningBtn.setOnClickListener(this);
        bakingBtn.setOnClickListener(this);
        archeryBtn.setOnClickListener(this);
        singingBtn.setOnClickListener(this);
        bloggingBtn.setOnClickListener(this);
        bowlingBtn.setOnClickListener(this);
        photographyBtn.setOnClickListener(this);
        cookingBtn.setOnClickListener(this);
        readingBtn.setOnClickListener(this);
        travelBtn.setOnClickListener(this);
        artBtn.setOnClickListener(this);
        potteryBtn.setOnClickListener(this);
        hikingBtn.setOnClickListener(this);
        fishingBtn.setOnClickListener(this);
        paintingBtn.setOnClickListener(this);
        danceBtn.setOnClickListener(this);
        musicBtn.setOnClickListener(this);
        woodworkingBtn.setOnClickListener(this);
        yogaBtn.setOnClickListener(this);
        calligraphyBtn.setOnClickListener(this);
        chessBtn.setOnClickListener(this);
        knittingBtn.setOnClickListener(this);

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

            case R.id.sportsHobbiesButton:
                if(sportsBtn.isSelected() == false){
                    sportsBtn.setSelected(true);
                    sportsBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(sportsBtn.isSelected() == true){
                    sportsBtn.setSelected(false);
                    sportsBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }

                break;

            case R.id.bikingHobbiesButton:
                if(bikingBtn.isSelected() == false){
                    bikingBtn.setSelected(true);
                    bikingBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(bikingBtn.isSelected() == true) {
                    bikingBtn.setSelected(false);
                    bikingBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.gardeningHobbiesButton:
                if(gardeningBtn.isSelected() == false){
                    gardeningBtn.setSelected(true);
                    gardeningBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(gardeningBtn.isSelected() == true) {
                    gardeningBtn.setSelected(false);
                    gardeningBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.bakingHobbiesButton:
                if(bakingBtn.isSelected() == false){
                    bakingBtn.setSelected(true);
                    bakingBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(bakingBtn.isSelected() == true) {
                    bakingBtn.setSelected(false);
                    bakingBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.archeryHobbiesButton:
                if(archeryBtn.isSelected() == false){
                    archeryBtn.setSelected(true);
                    archeryBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(archeryBtn.isSelected() == true) {
                    archeryBtn.setSelected(false);
                    archeryBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.singingHobbiesButton:
                if(singingBtn.isSelected() == false){
                    singingBtn.setSelected(true);
                    singingBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(singingBtn.isSelected() == true) {
                    singingBtn.setSelected(false);
                    singingBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.bloggingHobbiesButton:
                if(bloggingBtn.isSelected() == false){
                    bloggingBtn.setSelected(true);
                    bloggingBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(bloggingBtn.isSelected() == true) {
                    bloggingBtn.setSelected(false);
                    bloggingBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.bowlingHobbiesButton:
                if(bowlingBtn.isSelected() == false){
                    bowlingBtn.setSelected(true);
                    bowlingBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(bowlingBtn.isSelected() == true) {
                    bowlingBtn.setSelected(false);
                    bowlingBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.photographyHobbiesButton:
                if(photographyBtn.isSelected() == false){
                    photographyBtn.setSelected(true);
                    photographyBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(photographyBtn.isSelected() == true) {
                    photographyBtn.setSelected(false);
                    photographyBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.cookingHobbiesButton:
                if(cookingBtn.isSelected() == false){
                    cookingBtn.setSelected(true);
                    cookingBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(cookingBtn.isSelected() == true) {
                    cookingBtn.setSelected(false);
                    cookingBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.readingHobbiesButton:
                if(readingBtn.isSelected() == false){
                    readingBtn.setSelected(true);
                    readingBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(readingBtn.isSelected() == true) {
                    readingBtn.setSelected(false);
                    readingBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.travelHobbiesButton:
                if(travelBtn.isSelected() == false){
                    travelBtn.setSelected(true);
                    travelBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(travelBtn.isSelected() == true) {
                    travelBtn.setSelected(false);
                    travelBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.artHobbiesButton:
                if(artBtn.isSelected() == false){
                    artBtn.setSelected(true);
                    artBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(artBtn.isSelected() == true) {
                    artBtn.setSelected(false);
                    artBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.potteryHobbiesButton:
                if(potteryBtn.isSelected() == false){
                    potteryBtn.setSelected(true);
                    potteryBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(potteryBtn.isSelected() == true) {
                    potteryBtn.setSelected(false);
                    potteryBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.hikingHobbiesButton:
                if(hikingBtn.isSelected() == false){
                    hikingBtn.setSelected(true);
                    hikingBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(hikingBtn.isSelected() == true) {
                    hikingBtn.setSelected(false);
                    hikingBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.fishingHobbiesButton:
                if(fishingBtn.isSelected() == false){
                    fishingBtn.setSelected(true);
                    fishingBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(fishingBtn.isSelected() == true) {
                    fishingBtn.setSelected(false);
                    fishingBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.paintingHobbiesButton:
                if(paintingBtn.isSelected() == false){
                    paintingBtn.setSelected(true);
                    paintingBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(paintingBtn.isSelected() == true) {
                    paintingBtn.setSelected(false);
                    paintingBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.danceHobbiesButton:
                if(danceBtn.isSelected() == false){
                    danceBtn.setSelected(true);
                    danceBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(danceBtn.isSelected() == true) {
                    danceBtn.setSelected(false);
                    danceBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.musicHobbiesButton:
                if(musicBtn.isSelected() == false){
                    musicBtn.setSelected(true);
                    musicBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(musicBtn.isSelected() == true) {
                    musicBtn.setSelected(false);
                    musicBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.woodworkingHobbiesButton:
                if(woodworkingBtn.isSelected() == false){
                    woodworkingBtn.setSelected(true);
                    woodworkingBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(woodworkingBtn.isSelected() == true) {
                    woodworkingBtn.setSelected(false);
                    woodworkingBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.yogaHobbiesButton:
                if(yogaBtn.isSelected() == false){
                    yogaBtn.setSelected(true);
                    yogaBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(yogaBtn.isSelected() == true) {
                    yogaBtn.setSelected(false);
                    yogaBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.calligraphyHobbiesButton:
                if(calligraphyBtn.isSelected() == false){
                    calligraphyBtn.setSelected(true);
                    calligraphyBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(calligraphyBtn.isSelected() == true) {
                    calligraphyBtn.setSelected(false);
                    calligraphyBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.chessHobbiesButton:
                if(chessBtn.isSelected() == false){
                    chessBtn.setSelected(true);
                    chessBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(chessBtn.isSelected() == true) {
                    chessBtn.setSelected(false);
                    chessBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.knittingHobbiesButton:
                if(knittingBtn.isSelected() == false){
                    knittingBtn.setSelected(true);
                    knittingBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(knittingBtn.isSelected() == true) {
                    knittingBtn.setSelected(false);
                    knittingBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            default:
                break;

        }
    }

    public void checkSelected(TextView hobbiesView){
        hobbiesView.setText("");
        if(bikingBtn.isSelected() == true){
            hobbiesView.append(bikingBtn.getText() + " | ");
        }

        if(sportsBtn.isSelected() == true){
            hobbiesView.append(sportsBtn.getText() + " | ");
        }

        if(gardeningBtn.isSelected() == true){
            hobbiesView.append(gardeningBtn.getText() + " | ");
        }

        if(bakingBtn.isSelected() == true){
            hobbiesView.append(bakingBtn.getText() + " | ");
        }

        if(archeryBtn.isSelected() == true){
            hobbiesView.append(archeryBtn.getText() + " | ");
        }

        if(singingBtn.isSelected() == true){
            hobbiesView.append(singingBtn.getText() + " | ");
        }

        if(bloggingBtn.isSelected() == true){
            hobbiesView.append(bloggingBtn.getText() + " | ");
        }

        if(bowlingBtn.isSelected() == true){
            hobbiesView.append(bowlingBtn.getText() + " | ");
        }

        if(photographyBtn.isSelected() == true){
            hobbiesView.append(photographyBtn.getText() + " | ");
        }

        if(cookingBtn.isSelected() == true){
            hobbiesView.append(cookingBtn.getText() + " | ");
        }

        if(readingBtn.isSelected() == true){
            hobbiesView.append(readingBtn.getText() + " | ");
        }

        if(travelBtn.isSelected() == true){
            hobbiesView.append(travelBtn.getText() + " | ");
        }

        if(artBtn.isSelected() == true){
            hobbiesView.append(artBtn.getText() + " | ");
        }

        if(potteryBtn.isSelected() == true){
            hobbiesView.append(potteryBtn.getText() + " | ");
        }

        if(hikingBtn.isSelected() == true){
            hobbiesView.append(hikingBtn.getText() + " | ");
        }

        if(fishingBtn.isSelected() == true){
            hobbiesView.append(fishingBtn.getText() + " | ");
        }

        if(paintingBtn.isSelected() == true){
            hobbiesView.append(paintingBtn.getText() + " | ");
        }

        if(danceBtn.isSelected() == true){
            hobbiesView.append(danceBtn.getText() + " | ");
        }

        if(musicBtn.isSelected() == true){
            hobbiesView.append(musicBtn.getText() + " | ");
        }

        if(woodworkingBtn.isSelected() == true){
            hobbiesView.append(woodworkingBtn.getText() + " | ");
        }

        if(yogaBtn.isSelected() == true){
            hobbiesView.append(yogaBtn.getText() + " | ");
        }
        if(calligraphyBtn.isSelected() == true){
            hobbiesView.append(calligraphyBtn.getText() + " | ");
        }

        if(chessBtn.isSelected() == true){
            hobbiesView.append(chessBtn.getText() + " | ");
        }
        if(knittingBtn.isSelected() == true){
            hobbiesView.append(knittingBtn.getText() + " | ");
        }
    }
}