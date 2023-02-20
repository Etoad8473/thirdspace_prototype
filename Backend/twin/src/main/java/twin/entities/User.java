package twin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    //private Personality personality;
    private int personality;

    @Column(name = "name")
    private String userName;

    @Column(name = "password")
    private String password;


    public User() {}

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


    public int getPersonality() {
        return personality;
    }

    public void setPersonality(int personality) {
        this.personality = personality;
    }

    public String getUserName() {
        return userName;
    }

    /*
    Can be used to check if an entered username matches the username.
    Could be used during log in or when finding a friend from the repository
    -Charlie
     */
    public boolean usernameCheck(String user){
        return this.userName.equals(user);
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

    /*
    Used to compare two passwords and returns true if they match (false if they don't)
    Could be used during sign in or sign up
    -Charlie
     */
    public boolean passwordCheck(String pass){
        return this.password.equals(pass);
    }



}
