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

    @Autowired
    private UserRepository userRepo;

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


    public User generateMatchA(User u)
    {
        //get users hobbies
        //for each hobby the user has
            //for each hobby, return all users with that hobby
                //check if in map

            //potential list, return the highest connection
        HashMap<Long, Integer> potential = new HashMap<Long, Integer>();

        List<Hobby> hobbies = u.getPersonality().getHobbies();
        for(Hobby h:hobbies)
        {
            List<Personality> personalities = h.getPersonalities();
            for(Personality p : personalities)
            {
                Long id = p.getId();
                if(potential.containsKey(id))
                    potential.put(id, potential.get(id) + 1);
                else
                    potential.put(id, 1);
            }
        }

        Long id = Collections.max(potential.entrySet(), Map.Entry.comparingByValue()).getKey();

        return userRepo.findById(id).get();
    }


    public User generateMatchB()
    {
        Random rand = new Random();

        Hobby h = hobbies.get(rand.nextInt(hobbies.size()));
        List<Personality> persons = h.getPersonalities();
        User randFriend = persons.get(rand.nextInt(persons.size())).getUser();

        return randFriend;
    }


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
