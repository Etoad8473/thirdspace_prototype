package twin.Personality;

import twin.User.User;
import twin.Hobby.Hobby;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="personalities")
public class Personality
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @OneToOne
    private User user;

    @ManyToMany
    private List<Hobby> hobbies;

    public Personality(){hobbies = new ArrayList<>();}

    public void addHobby(Hobby h){hobbies.add(h);}

    public void setUser(User u){this.user = u;}

    @Override
    public String toString(){ return hobbies.toString();}

}
