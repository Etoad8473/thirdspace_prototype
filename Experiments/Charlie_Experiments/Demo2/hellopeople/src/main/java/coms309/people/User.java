package coms309.people;

public class User {

    private String username;  //stores user username

    private String password;  // stores user password


    //creates a user object
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    // returns username variable
    public String getUsername(){
        return this.username;
    }
    // Changes a user's username
    public void setUsername(String username){
        this.username = username;
    }

    // returns password variable (bad security practice)
    public String getPassword(){
        return this.password;
    }
    // Changes a user's password
    public void setPassword(String password){
        this.password = password;
    }

    //can be used to check if two entered passwords are the same
    //I see two uses for this 1 to check if the password entered is correct at login
    //secondly to double-check something like enter password and reenter password while creating an account
    public boolean passwordCheck(String pass1, String pass2){
        return pass1.equals(pass2);
    }
}
