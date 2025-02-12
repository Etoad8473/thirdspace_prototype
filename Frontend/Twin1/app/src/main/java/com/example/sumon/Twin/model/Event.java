package com.example.sumon.Twin.model;

public class Event {
    private String eventName;
    private String time;
    private String location;

    public Event(){
    }

    public void setEventName(String name){
        this.eventName = name;
    }
    public String getEventName(){
        return eventName;
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
