package twin.GroupChat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import twin.Group.Group;
import twin.Message.Message;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name="GroupChat")
public class GroupChat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @OneToOne
    @JsonIgnore
    private Group group;

    @OneToMany
    //@Column(name = "messages")
    private List<Message> messages; //List of messages sent in the GroupChat (a log)

    //Constructor
    public GroupChat(){
        messages = new ArrayList<Message>();
    }

    public GroupChat(Group g){
        this.group = g;
        messages = new ArrayList<Message>();
    }

    public void setGroup(Group g){
        this.group = g;
    }

    @Override
    public String toString() {
        return messages.toString();
    }

    public List<Message> getMessages(){
        return messages;
    }

    public void setMessages(List<Message> newMessages){
        messages = newMessages;
    }

    public void addMessage(Message message){
        messages.add(message);
    }

    public void removeMessage(Message message){
        messages.remove(message);
    }
}
