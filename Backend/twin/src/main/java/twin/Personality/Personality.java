package twin.Personality;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import twin.Personality.Interests.Interest;
import twin.Personality.Values.Value;
import twin.User.User;
import twin.Personality.Hobby.Hobby;
import twin.User.UserRepository;

import javax.persistence.*;
import java.util.*;

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

    @ManyToMany
    private List<Interest> interests;

    @ManyToMany
    private List<Value> values;


    //------------------------------Constructor--------------------------//
    public Personality()
    {
        interests = new ArrayList<Interest>();
        hobbies = new ArrayList<Hobby>();
        values = new ArrayList<Value>();
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

    public boolean addInterest(Interest i)
    {
        if(i != null)
        {
            interests.add(i);
            //h.setPersonality(this);
            i.addPersonality(this);
            return true;
        }
        else
            return false;
    }

    public boolean addValue(Value v)
    {
        if(v != null)
        {
            values.add(v);
            //h.setPersonality(this);
            v.addPersonality(this);
            return true;
        }
        else
            return false;
    }





    public User generateMatchB()
    {
        Random rand = new Random();

        Hobby h = hobbies.get(rand.nextInt(hobbies.size()));
        List<Personality> persons = h.getPersonalities();
        User randFriend = persons.get(rand.nextInt(persons.size())).getUser();

        return randFriend;
    }


//    public ArrayList<User> createGroup(User u)
//    {
//        ArrayList<User> group = new ArrayList<User>();
//
//        u.getPersonality().getHobbies();
//    }

    @Override
    public String toString(){
        return "" + hobbies.toString() +"\n\n"+ interests.toString();
    }


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

    public List<Interest> getInterests(){return interests;}

    public List<Value> getValues(){return values;}
}
