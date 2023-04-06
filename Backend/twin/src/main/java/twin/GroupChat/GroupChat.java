package twin.GroupChat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class GroupChat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name = "groupChatName")
    private String groupChatName; //name of the GroupChat

    @OneToMany
    @Column(name = "messages")
    private List<Message> messages; //List of messages sent in the GroupChat (a log)

    public GroupChat(){
        messages = new ArrayList<>();
    }

    public GroupChat(String groupChatName){
        this.groupChatName = groupChatName;
        messages = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "GroupChat{" +
                "groupChatName=" + groupChatName + '\'' +
                '}';
    }

    public String getGroupChatName(){
        return groupChatName;
    }

    public void setGroupChatName(String groupChatName){
        this.groupChatName = groupChatName;
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
