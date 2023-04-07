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
            patriotismBtn, knowledgeBtn, leadershipBtn, natureBtn, sportsmanshipBtn, respectBtn, teamworkBtn, wealthBtn;
    private TextView selectedView;

    private EditText age, ethnicity, sexuality, location, mobile,goal1, goal2;

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
        wealthBtn = (Button) findViewById(R.id.wealthBtn);


        doneBtn = (Button) findViewById(R.id.personalityDoneButton);
        selectedView = (TextView) findViewById(R.id.viewSelected);

        age = (EditText) findViewById(R.id.ageEditText);
        ethnicity = (EditText) findViewById(R.id.ethnicityEditText);
        sexuality = (EditText) findViewById(R.id.sexualityEditText);
        location = (EditText) findViewById(R.id.locationEditText);
        mobile = (EditText) findViewById(R.id.mobileEditText);
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
        wealthBtn.setOnClickListener(this);


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


            case R.id.accountabilityBtn:
                if(accountabilityBtn.isSelected() == false){
                    accountabilityBtn.setSelected(true);
                    accountabilityBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(accountabilityBtn.isSelected() == true) {
                    accountabilityBtn.setSelected(false);
                    accountabilityBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.achievementBtn:
                if(achievementBtn.isSelected() == false){
                    achievementBtn.setSelected(true);
                    achievementBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(achievementBtn.isSelected() == true) {
                    achievementBtn.setSelected(false);
                    achievementBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.adaptabilityBtn:
                if(adaptabilityBtn.isSelected() == false){
                    adaptabilityBtn.setSelected(true);
                    adaptabilityBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(adaptabilityBtn.isSelected() == true) {
                    adaptabilityBtn.setSelected(false);
                    adaptabilityBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.adventureBtn:
                if(adventureBtn.isSelected() == false){
                    adventureBtn.setSelected(true);
                    adventureBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(adventureBtn.isSelected() == true) {
                    adventureBtn.setSelected(false);
                    adventureBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.ambitionBtn:
                if(ambitionBtn.isSelected() == false){
                    ambitionBtn.setSelected(true);
                    ambitionBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(ambitionBtn.isSelected() == true) {
                    ambitionBtn.setSelected(false);
                    ambitionBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.careerBtn:
                if(careerBtn.isSelected() == false){
                    careerBtn.setSelected(true);
                    careerBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(careerBtn.isSelected() == true) {
                    careerBtn.setSelected(false);
                    careerBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.communityBtn:
                if(communityBtn.isSelected() == false){
                    communityBtn.setSelected(true);
                    communityBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(communityBtn.isSelected() == true) {
                    communityBtn.setSelected(false);
                    communityBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.friendshipBtn:
                if(friendshipBtn.isSelected() == false){
                    friendshipBtn.setSelected(true);
                    friendshipBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(friendshipBtn.isSelected() == true) {
                    friendshipBtn.setSelected(false);
                    friendshipBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.confidenceBtn:
                if(confidienceBtn.isSelected() == false){
                    confidienceBtn.setSelected(true);
                    confidienceBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(confidienceBtn.isSelected() == true) {
                    confidienceBtn.setSelected(false);
                    confidienceBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.harmonyBtn:
                if(harmonyBtn.isSelected() == false){
                    harmonyBtn.setSelected(true);
                    harmonyBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(harmonyBtn.isSelected() == true) {
                    harmonyBtn.setSelected(false);
                    harmonyBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.graceBtn:
                if(graceBtn.isSelected() == false){
                    graceBtn.setSelected(true);
                    graceBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(graceBtn.isSelected() == true) {
                    graceBtn.setSelected(false);
                    graceBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.honestyBtn:
                if(honestyBtn.isSelected() == false){
                    honestyBtn.setSelected(true);
                    honestyBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(honestyBtn.isSelected() == true) {
                    honestyBtn.setSelected(false);
                    honestyBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.freedomBtn:
                if(freedomBtn.isSelected() == false){
                    freedomBtn.setSelected(true);
                    freedomBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(freedomBtn.isSelected() == true) {
                    freedomBtn.setSelected(false);
                    freedomBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.faithBtn:
                if(faithBtn.isSelected() == false){
                    faithBtn.setSelected(true);
                    faithBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(faithBtn.isSelected() == true) {
                    faithBtn.setSelected(false);
                    faithBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.ethicsBtn:
                if(ethicsBtn.isSelected() == false){
                    ethicsBtn.setSelected(true);
                    ethicsBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(ethicsBtn.isSelected() == true) {
                    ethicsBtn.setSelected(false);
                    ethicsBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.patriotismBtn:
                if(patriotismBtn.isSelected() == false){
                    patriotismBtn.setSelected(true);
                    patriotismBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(patriotismBtn.isSelected() == true) {
                    patriotismBtn.setSelected(false);
                    patriotismBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.knowledgeBtn:
                if(knowledgeBtn.isSelected() == false){
                    knowledgeBtn.setSelected(true);
                    knowledgeBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(knowledgeBtn.isSelected() == true) {
                    knowledgeBtn.setSelected(false);
                    knowledgeBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.leadershipBtn:
                if(leadershipBtn.isSelected() == false){
                    leadershipBtn.setSelected(true);
                    leadershipBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(leadershipBtn.isSelected() == true) {
                    leadershipBtn.setSelected(false);
                    leadershipBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.natureBtn:
                if(natureBtn.isSelected() == false){
                    natureBtn.setSelected(true);
                    natureBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(natureBtn.isSelected() == true) {
                    natureBtn.setSelected(false);
                    natureBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.sportsmanshipBtn:
                if(sportsmanshipBtn.isSelected() == false){
                    sportsmanshipBtn.setSelected(true);
                    sportsmanshipBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(sportsmanshipBtn.isSelected() == true) {
                    sportsmanshipBtn.setSelected(false);
                    sportsmanshipBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.respectBtn:
                if(respectBtn.isSelected() == false){
                    respectBtn.setSelected(true);
                    respectBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(respectBtn.isSelected() == true) {
                    respectBtn.setSelected(false);
                    respectBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.teamworkBtn:
                if(teamworkBtn.isSelected() == false){
                    teamworkBtn.setSelected(true);
                    teamworkBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(teamworkBtn.isSelected() == true) {
                    teamworkBtn.setSelected(false);
                    teamworkBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
                }
                break;

            case R.id.wealthBtn:
                if(wealthBtn.isSelected() == false){
                    wealthBtn.setSelected(true);
                    wealthBtn.setBackgroundColor(getResources().getColor(R.color.grey));
                }
                else if(wealthBtn.isSelected() == true) {
                    wealthBtn.setSelected(false);
                    wealthBtn.setBackgroundColor(getResources().getColor(R.color.red_grey));
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

        //Lifestyle
        if(activeBtn.isSelected() == true){
            hobbiesView.append(activeBtn.getText() + " | ");
        }

        if(healthyBtn.isSelected() == true){
            hobbiesView.append(healthyBtn.getText() + " | ");
        }

        if(soloBtn.isSelected() == true){
            hobbiesView.append(soloBtn.getText() + " | ");
        }

        if(ruralBtn.isSelected() == true){
            hobbiesView.append(ruralBtn.getText() + " | ");
        }

        if(urbanBtn.isSelected() == true){
            hobbiesView.append(urbanBtn.getText() + " | ");
        }

        if(nomadicBtn.isSelected() == true){
            hobbiesView.append(nomadicBtn.getText() + " | ");
        }

        if(bohemianBtn.isSelected() == true){
            hobbiesView.append(bohemianBtn.getText() + " | ");
        }

        if(digitalBtn.isSelected() == true){
            hobbiesView.append(digitalBtn.getText() + " | ");
        }


        // Values
        if(accountabilityBtn.isSelected() == true){
            hobbiesView.append(accountabilityBtn.getText() + " | ");
        }

        if(achievementBtn.isSelected() == true){
            hobbiesView.append(achievementBtn.getText() + " | ");
        }

        if(adaptabilityBtn.isSelected() == true){
            hobbiesView.append(adaptabilityBtn.getText() + " | ");
        }

        if(adventureBtn.isSelected() == true){
            hobbiesView.append(adventureBtn.getText() + " | ");
        }

        if(ambitionBtn.isSelected() == true){
            hobbiesView.append(ambitionBtn.getText() + " | ");
        }

        if(careerBtn.isSelected() == true){
            hobbiesView.append(careerBtn.getText() + " | ");
        }

        if(caringBtn.isSelected() == true){
            hobbiesView.append(communityBtn.getText() + " | ");
        }

        if(friendshipBtn.isSelected() == true){
            hobbiesView.append(friendshipBtn.getText() + " | ");
        }

        if(confidienceBtn.isSelected() == true){
            hobbiesView.append(confidienceBtn.getText() + " | ");
        }

        if(harmonyBtn.isSelected() == true){
            hobbiesView.append(harmonyBtn.getText() + " | ");
        }

        if(graceBtn.isSelected() == true){
            hobbiesView.append(graceBtn.getText() + " | ");
        }

        if(honestyBtn.isSelected() == true){
            hobbiesView.append(honestyBtn.getText() + " | ");
        }

        if(freedomBtn.isSelected() == true){
            hobbiesView.append(freedomBtn.getText() + " | ");
        }

        if(faithBtn.isSelected() == true){
            hobbiesView.append(faithBtn.getText() + " | ");
        }

        if(ethicsBtn.isSelected() == true){
            hobbiesView.append(ethicsBtn.getText() + " | ");
        }

        if(patriotismBtn.isSelected() == true){
            hobbiesView.append(patriotismBtn.getText() + " | ");
        }

        if(knowledgeBtn.isSelected() == true){
            hobbiesView.append(knowledgeBtn.getText() + " | ");
        }

        if(leadershipBtn.isSelected() == true){
            hobbiesView.append(leadershipBtn.getText() + " | ");
        }

        if(natureBtn.isSelected() == true){
            hobbiesView.append(natureBtn.getText() + " | ");
        }

        if(sportsmanshipBtn.isSelected() == true){
            hobbiesView.append(sportsmanshipBtn.getText() + " | ");
        }

        if(respectBtn.isSelected() == true){
            hobbiesView.append(respectBtn.getText() + " | ");
        }

        if(teamworkBtn.isSelected() == true){
            hobbiesView.append(teamworkBtn.getText() + " | ");
        }

        if(wealthBtn.isSelected() == true){
            hobbiesView.append(wealthBtn.getText() + " | ");
        }
    }
}