package com.example.sumon.androidvolley.model;
/**
 * @author kaiheng
 */
public class Personality {
    private String hobbies;
    private String interest;
    private String demographic;
    private String lifestyle;
    private String values;
    private String goals;

    public Personality(){
    }

    public void setHobbies(String hobbies){
        this.hobbies = hobbies;
    }

    public String getHobbies(){
        return hobbies;
    }

    public void setInterest(String interest){
        this.interest = interest;
    }

    public String getInterest(){
        return interest;
    }

    public void setDemographic(String demographic){
        this.demographic = demographic;
    }

    public String getDemographic(){
        return demographic;
    }

    public void setLifestyle(String lifestyle){
        this.lifestyle = lifestyle;
    }

    public String getLifestyle(){
        return lifestyle;
    }

    public void setValues(String values){
        this.values = values;
    }

    public String getValues(){
        return values;
    }

    public void setGoals(String goals){
        this.goals = goals;
    }

    public String getGoals(){
        return goals;
    }

    public String printable(){
        return "\n Hobbies: "+ getHobbies()
                + "\n Interests: " + getInterest()
                + "\n Demographic: " + getDemographic()
                + "\n Lifestyle: " + getLifestyle()
                + "\n Values: " + getValues()
                + "\n Goals: " + getGoals();
    }
}
