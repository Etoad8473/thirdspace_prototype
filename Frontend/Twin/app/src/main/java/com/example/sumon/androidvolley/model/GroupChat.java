package com.example.sumon.androidvolley.model;

public class GroupChat {
    private String sender;
    private String time;
    private String date;
    private String data;
    private String groupName;

    public GroupChat(){
    }

    public void setSender(String sender){
        this.sender = sender;
    }
    public String getSender(){
        return sender;
    }

    public void setTime(String time){
        this.time = time;
    }
    public String getTime(){
        return time;
    }

    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return date;
    }

    public void setData(String data){
        this.data = data;
    }
    public String getData(){
        return data;
    }

//    public void setGroupName(String groupName){
//        this.groupName = groupName;
//    }
//    public String getGroupName(){
//        return groupName;
//    }

    public String printable(){
        return getDate() + " | " +getTime() +
                "\n" + getSender() + ": " + getData() + "\n";
    }
}
