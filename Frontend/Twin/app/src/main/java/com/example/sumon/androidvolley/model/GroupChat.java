package com.example.sumon.androidvolley.model;

public class GroupChat {
    private String username;
    private String time;
    private String date;
    private String messages;

    public GroupChat(){
    }

    public void setUsername(String name){
        this.username = name;
    }
    public String getUsername(){
        return username;
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

    public void setMessages(String messages){
        this.messages = messages;
    }
    public String getMessages(){
        return messages;
    }

    public String printable(){
        return getDate() + " | " +getTime() +
                "\n" + getUsername() + ": " + getMessages() + "\n";
    }
}
