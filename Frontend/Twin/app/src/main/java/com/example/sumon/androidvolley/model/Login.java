package com.example.sumon.androidvolley.model;

public class Login {
    private String username;
    private String password;
    private int id;

    public Login(){}

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public int getId(){
        return id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String printable(){
        return "ID: " + getId() +
                "\nUsername: " + getUsername() +
                "\nPassword: " + getPassword() + "\n";
    }
}
