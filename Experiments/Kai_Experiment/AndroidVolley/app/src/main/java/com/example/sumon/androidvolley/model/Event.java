package com.example.sumon.androidvolley.model;

public class Event {
    private String name;
    private String time;
    private String location;

    public Event(){
    }

    public void setEventName(String name){
        this.name = name;
    }
    public String getEventName(){
        return name;
    }

    public void setTime(String time){
        this.time = time;
    }
    public String getTime(){
        return time;
    }

    public void setLocation(String location){
        this.location = location;
    }
    public String getLocation(){
        return location;
    }

    public String printable(){
        return "\nEvent:  "+ getEventName()
                +"\nTime:  "+getTime()
                +"\nLocation:  "+getLocation()+"\n";
    }
}
