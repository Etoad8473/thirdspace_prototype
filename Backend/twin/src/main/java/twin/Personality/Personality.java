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


    //------------------------------Constructor--------------------------//
    public Personality(){hobbies = new ArrayList<>();}


    //-----------------------------Methods-------------------------------//
    public boolean addHobby(Hobby h)
    {
        if(h != null)
        {
            hobbies.add(h);
            return true;
        }
        else
            return false;
    }

    @Override
    public String toString(){ return hobbies.toString();}


    //----------------------------Getters/Setters--------------------------//
    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User u){this.user = u;}

    public List<Hobby> getHobbies() {
        return hobbies;
    }
}
