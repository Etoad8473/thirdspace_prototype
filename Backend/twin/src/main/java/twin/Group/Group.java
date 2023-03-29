package twin.Group;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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

    //different group sizes
    public static int small = 4;

    public static int medium = 8;

    public static int large = 12;

    public static int community = 1000;

    @Column(name = "size")
    private int size; //size of the group

    @OneToMany
    @Column(name = "users")
    private List<User> users;

    public Group() {
        users = new ArrayList<>();
    }

    public Group(String name, int size){
        groupName = name;
        setSize(size);
        users = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName=" + groupName +
                ", size='" + size + '\'' +
                '}';
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

    public void setUsers(List<User> users){
        this.users = users;
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public void removeUser(User user) { this.users.remove(user); }

}