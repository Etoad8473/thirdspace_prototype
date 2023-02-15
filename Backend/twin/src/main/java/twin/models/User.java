package twin.models;


public class User {

    public User(String name, String password, int type)
    {
        userName = name;
        this.password = password;
        personality = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "personality=" + personality +
                ", userName='" + userName + '\'' +
                ", password (FOR TESTING PURPOSES) ='" + password + '\'' +
                '}';
    }

    //private Personality personality;
    private int personality;

    private String userName;

    private String password;


    public int getPersonality() {
        return personality;
    }

    public void setPersonality(int personality) {
        this.personality = personality;
    }

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
