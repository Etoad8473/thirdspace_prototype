package com.example.sumon.androidvolley.model;

public class Match {
    private String groupName;

    public Match(){
    }

    public String getGroupName(){
        return groupName;
    }

    public String printable(){
        return "Congratulations!!! \n New Matched group: "+ getGroupName();
    }
}
