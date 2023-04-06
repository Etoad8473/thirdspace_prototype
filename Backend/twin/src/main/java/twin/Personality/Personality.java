package twin.Personality;

import com.fasterxml.jackson.annotation.JsonIgnore;
import twin.User.User;
import twin.Personality.Hobby.Hobby;

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
    @JsonIgnore
    private User user;

    @ManyToMany
    private List<Hobby> hobbies;


    //------------------------------Constructor--------------------------//
    public Personality()
    {
        hobbies = new ArrayList<Hobby>();
    }


    //-----------------------------Methods-------------------------------//
    public boolean addHobby(Hobby h)
    {
        if(h != null)
        {
            hobbies.add(h);
            //h.setPersonality(this);
            h.addPersonality(this);
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
