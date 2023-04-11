package twin.User;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import twin.Event.Event;
import twin.Personality.Personality;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="users")
public class User {

    /*
    Kai wants us to add email, phone number, gender, and actual name(along with username)
     */


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @OneToOne(cascade = {CascadeType.ALL})
    private Personality personality;
    //private int personality;

    //stores user's email
    @Column(name = "email")
    private String email;

    //stores user's name
    @Column(name = "name")
    private String name;

    @Column(name = "userName")
    private String userName;

    @Column(name = "password")
    private String password;

    //stores user's gender
    @Column(name = "gender")
    private String gender;

    @Column(name = "phone")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonIgnore
    private Event event;

    @ManyToMany
    @JsonIgnore
    private List<User> friends;

    public User() {
        personality = new Personality();
        personality.setUser(this);
        friends = new ArrayList<User>();
    }

    public User(String userName, String password, String name, String email, String gender, String phone)
    {
        this.userName = userName;
        this.password = password;
        this.personality = new Personality();
        this.name = name;
        this.email = email;
        this.gender = gender;
        phoneNumber = phone;
        friends = new ArrayList<User>();

        personality.setUser(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "personality=" + personality +
                ", userName='" + userName + '\'' +
                ", password (FOR TESTING PURPOSES) ='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }



    public long getId() {
        return id;
    }
    public Personality getPersonality() {
        return personality;
    }

    public void setPersonality(Personality personality) {
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

    //returns user's name
    public String getName(){ return name; }

    //sets the user's name to given newName
    public void setName(String newName){
        name = newName;
    }

    //returns user's email
    public String getEmail(){ return email; }

    //sets the user's email to given newEmail
    public void setEmail(String newEmail){
        email = newEmail;
    }

    //returns user's gender
    public String getGender(){ return gender; }

    //sets the user's gender to given newGender
    public void setGender(String newGender){
        gender = newGender;
    }

    //returns user's phone number
    public String getPhoneNumber(){ return phoneNumber; }

    //sets the user's phone number to given newNumber
    public void setPhoneNumber(String newNumber){
        phoneNumber = newNumber;
    }

    //for many to one
    public Event getEvent(){
        return event;
    }

    //for many to one
    public void setEvent(Event event){
        this.event = event;
    }

    //returns a list of the user's friends
    public List<User> getFriends(){
        return friends;
    }

    //set all the users friends at once
    public void setFriends(List<User> friends){
        this.friends = friends;
    }

    //user can add a friend one at a time
    public void addFriend(User friend){

        this.friends.add(friend);
        friend.friends.add(this);
    }

    public void removeFriend(User friend) { this.friends.remove(friend); }

}
