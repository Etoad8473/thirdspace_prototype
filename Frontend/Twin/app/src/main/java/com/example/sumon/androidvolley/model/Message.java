package com.example.sumon.androidvolley.model;
/**
 * @author kaiheng
 */
public class Message {
    private Trivia sender;
    private String time;
    private String date;
    private String data;

    public Message(){
    }

    public void setSender(Trivia sender){
        this.sender = sender;
    }
    public String getSender(){
        return sender.getName();
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
