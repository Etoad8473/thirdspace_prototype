package twin.Group;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import twin.GroupChat.GroupChat;
import twin.GroupChat.GroupChatController;
import twin.User.User;

@Entity
@Table(name="groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String groupName;
    @OneToOne(cascade = {CascadeType.ALL})
    private GroupChat groupChat;

    @ManyToMany
    private List<User> users;

    //different group sizes
    public static int small = 4;

    public static int medium = 8;

    public static int large = 12;

    public static int community = 1000;

    @Column(name = "size")
    private int size; //size of the group


    public Group() {
        users = new ArrayList<User>();
        groupChat = new GroupChat();
    }

    public Group(String name, int size) {
        groupName = name;
        setSize(size);
        groupChat = new GroupChat();
        users = new ArrayList<User>();
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName=" + groupName +
                ", size='" + size + '\'' +
                "groupChat=" + groupChat + '\'' +
                '}';
    }

    public long getId(){
        return id;
    }

    public GroupChat getGroupChat(){
        return groupChat;
    }

    public void setGroupChat(GroupChat groupChat){
        this.groupChat = groupChat;
    }

    public String getGroupName(){
        return groupName;
    }

    public void setGroupName(String newName){
        groupName = newName;
    }

    public int getSize(){
        return size;
    }

    public void setSize(int newSize){
        if(newSize <= small){
            size = small;
        }
        else if(newSize > small && newSize <= medium){
            size = medium;
        }
        else if(newSize > medium && newSize <= large){
            size = large;
        }
        else{
            size = community;
        }
    }

    public List<User> getUsers(){
        return users;
    }

    public void setUsers(List<User> userList)
    {
        this.users = userList;
        for(User u : userList)
        {
            u.addGroup(this);
        }
    }

    public void addUser(User u){
        users.add(u);
        //u.addGroup(this);
    }

    public void removeUser(User user) { this.users.remove(user); }

}