package twin.Message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import twin.Group.Group;
import twin.GroupChat.GroupChat;
import twin.User.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name = "data")
    private String data;  //will store the message the user is sending

    @Column(name = "date")
    private String date; //will store the date sent

    @Column(name = "time")
    private String time; //time the message is sent

    @OneToOne(cascade = {CascadeType.ALL})
    @Column(name = "sender")
    private User sender; //sender of the message


    public Message(){
    }

    public Message(String data, String date, String time, User sender){
        this.data = data;
        this.date = date;
        this.time = time;
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "Message{" +
                "data=" + getData() +
                ", date='" + getDate() + '\'' +
                ", time ='" + getTime() + '\'' +
                ", sender='" + getSender() + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getData(){
        return data;
    }

    public void setData(String newData){
        data = newData;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String newDate){
        date = newDate;
    }

    public String getTime(){
        return time;
    }

    public void setTime(String newTime){
        time = newTime;
    }

    public User getSender(){
        return sender;
    }

    public void setSender(User newSender){
        sender = newSender;
    }


}
