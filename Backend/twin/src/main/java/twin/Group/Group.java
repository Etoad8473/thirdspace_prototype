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

}