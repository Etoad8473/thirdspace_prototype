package com.example.sumon.androidvolley;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class PersonalityBuilder extends AppCompatActivity implements View.OnClickListener {
    //Hobby Buttons
    private Button sportsBtn, bikingBtn, gardeningBtn, bakingBtn, archeryBtn, singingBtn, bloggingBtn, bowlingBtn,
            photographyBtn, cookingBtn, readingBtn, travelBtn, artBtn, potteryBtn, hikingBtn, fishingBtn,
            paintingBtn, danceBtn, musicBtn, woodworkingBtn, yogaBtn, calligraphyBtn, chessBtn, knittingBtn, doneBtn;

    private Button activeBtn, healthyBtn, soloBtn, ruralBtn, urbanBtn, nomadicBtn, bohemianBtn, digitalBtn;
    private Button accountabilityBtn, achievementBtn, adaptabilityBtn, adventureBtn, ambitionBtn, careerBtn, caringBtn,
            communityBtn, friendshipBtn, confidienceBtn, harmonyBtn, graceBtn, honestyBtn, freedomBtn, faithBtn, ethicsBtn,
            patriotismBtn, knowledgeBtn, leadershipBtn, natureBtn, sportsmanshipBtn, respectBtn, teamworkBtn, wealth;
    private TextView selectedView;

    private EditText goal1, goal2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personality_builder);

        // Hobby Buttons
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

        //Lifestyle Buttons
        activeBtn = (Button) findViewById(R.id.activeLifestyleButton);
        healthyBtn = (Button) findViewById(R.id.healthyLifestyleButton);
        soloBtn = (Button) findViewById(R.id.soloLifestyleButton);
        ruralBtn = (Button) findViewById(R.id.ruralLifestyleButton);
        urbanBtn = (Button) findViewById(R.id.urbanLifestyleButton);
        nomadicBtn = (Button) findViewById(R.id.nomadicLifestyleButton);
        bohemianBtn = (Button) findViewById(R.id.bohemianLifestyleButton);
        digitalBtn = (Button) findViewById(R.id.digitalLifestyleButton);

        //Values Buttons
        accountabilityBtn = (Button) findViewById(R.id.accountabilityBtn);
        achievementBtn = (Button) findViewById(R.id.achievementBtn);
        adaptabilityBtn = (Button) findViewById(R.id.adaptabilityBtn);
        adventureBtn = (Button) findViewById(R.id.adventureBtn);
        ambitionBtn = (Button) findViewById(R.id.ambitionBtn);
        careerBtn = (Button) findViewById(R.id.careerBtn);
        caringBtn = (Button) findViewById(R.id.caringBtn);
        communityBtn = (Button) findViewById(R.id.communityBtn);
        friendshipBtn = (Button) findViewById(R.id.friendshipBtn);
        confidienceBtn = (Button) findViewById(R.id.confidenceBtn);
        harmonyBtn = (Button) findViewById(R.id.harmonyBtn);
        graceBtn = (Button) findViewById(R.id.graceBtn);
        honestyBtn = (Button) findViewById(R.id.honestyBtn);
        freedomBtn = (Button) findViewById(R.id.freedomBtn);
        faithBtn = (Button) findViewById(R.id.faithBtn);
        ethicsBtn = (Button) findViewById(R.id.ethicsBtn);
        patriotismBtn = (Button) findViewById(R.id.patriotismBtn);
        knowledgeBtn = (Button) findViewById(R.id.knowledgeBtn);
        leadershipBtn = (Button) findViewById(R.id.leadershipBtn);
        natureBtn = (Button) findViewById(R.id.natureBtn);
        sportsmanshipBtn = (Button) findViewById(R.id.sportsmanshipBtn);
        respectBtn = (Button) findViewById(R.id.respectBtn);
        teamworkBtn = (Button) findViewById(R.id.teamworkBtn);
        wealth = (Button) findViewById(R.id.wealthBtn);


        doneBtn = (Button) findViewById(R.id.personalityDoneButton);
        selectedView = (TextView) findViewById(R.id.viewSelected);

        goal1 = (EditText) findViewById(R.id.goalEditText1);
        goal2 = (EditText) findViewById(R.id.goalEditText2);


        //Hobbies
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

        //Lifestyle
        activeBtn.setOnClickListener(this);
        healthyBtn.setOnClickListener(this);
        soloBtn.setOnClickListener(this);
        ruralBtn.setOnClickListener(this);
        urbanBtn.setOnClickListener(this);
        nomadicBtn.setOnClickListener(this);
        bohemianBtn.setOnClickListener(this);
        digitalBtn.setOnClickListener(this);

        //Values
        accountabilityBtn.setOnClickListener(this);
        achievementBtn.setOnClickListener(this);
        adaptabilityBtn.setOnClickListener(this);
        adventureBtn.setOnClickListener(this);
        ambitionBtn.setOnClickListener(this);
        careerBtn.setOnClickListener(this);
        caringBtn.setOnClickListener(this);
        communityBtn.setOnClickListener(this);
        friendshipBtn.setOnClickListener(this);
        confidienceBtn.setOnClickListener(this);
        harmonyBtn.setOnClickListener(this);
        graceBtn.setOnClickListener(this);
        honestyBtn.setOnClickListener(this);
        freedomBtn.setOnClickListener(this);
        faithBtn.setOnClickListener(this);
        ethicsBtn.setOnClickListener(this);
        patriotismBtn.setOnClickListener(this);
        knowledgeBtn.setOnClickListener(this);
        leadershipBtn.setOnClickListener(this);
        natureBtn.setOnClickListener(this);
        sportsmanshipBtn.setOnClickListener(this);
        respectBtn.setOnClickListener(this);
        teamworkBtn.setOnClickListener(this);
        wealth.setOnClickListener(this);


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

            case R.id.activeLifestyleButton:
                if(activeBtn.isSelected() == false){
                    activeBtn.setSelected(true);
                    activeBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(activeBtn.isSelected() == true) {
                    activeBtn.setSelected(false);
                    activeBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.healthyLifestyleButton:
                if(healthyBtn.isSelected() == false){
                    healthyBtn.setSelected(true);
                    healthyBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(healthyBtn.isSelected() == true) {
                    healthyBtn.setSelected(false);
                    healthyBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.soloLifestyleButton:
                if(soloBtn.isSelected() == false){
                    soloBtn.setSelected(true);
                    soloBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(soloBtn.isSelected() == true) {
                    soloBtn.setSelected(false);
                    soloBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.ruralLifestyleButton:
                if(ruralBtn.isSelected() == false){
                    ruralBtn.setSelected(true);
                    ruralBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(ruralBtn.isSelected() == true) {
                    ruralBtn.setSelected(false);
                    ruralBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.urbanLifestyleButton:
                if(urbanBtn.isSelected() == false){
                    urbanBtn.setSelected(true);
                    urbanBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(urbanBtn.isSelected() == true) {
                    urbanBtn.setSelected(false);
                    urbanBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.nomadicLifestyleButton:
                if(nomadicBtn.isSelected() == false){
                    nomadicBtn.setSelected(true);
                    nomadicBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(nomadicBtn.isSelected() == true) {
                    nomadicBtn.setSelected(false);
                    nomadicBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.bohemianLifestyleButton:
                if(bohemianBtn.isSelected() == false){
                    bohemianBtn.setSelected(true);
                    bohemianBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(bohemianBtn.isSelected() == true) {
                    bohemianBtn.setSelected(false);
                    bohemianBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.digitalLifestyleButton:
                if(digitalBtn.isSelected() == false){
                    digitalBtn.setSelected(true);
                    digitalBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(digitalBtn.isSelected() == true) {
                    digitalBtn.setSelected(false);
                    digitalBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
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