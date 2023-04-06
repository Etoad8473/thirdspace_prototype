package twin.Personality.Hobby;

import com.fasterxml.jackson.annotation.JsonIgnore;
import twin.Personality.Personality;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Hobbies")
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;


    @Column(name="hobby_name")
    private String hobbyN;



    //----------Relations---------------//
    //@ManyToOne
    @ManyToMany
    @JsonIgnore
    //private Personality personality;
    private List<Personality> personalities;

    //----------Constructor-------------//

    public Hobby(){
        personalities = new ArrayList<Personality>();
    }

    public Hobby(String name)
    {
        personalities = new ArrayList<Personality>();
        this.hobbyN = name;
    }

    /*@ManyToOne
    private Hobby parentHobby;
    @OneToMany
    private List<Hobby> subHobbies;
    */

    //----------Getter/Setter--------------//


    /*public Personality getPersonality() {
        return personality;
    }

    public void setPersonality(Personality personality) {
        this.personality = personality;
    }*/

    public String getHobbyN() {
        return hobbyN;
    }

    public void setHobbyN(String hobbyN) {
        this.hobbyN = hobbyN;
    }
    public List<Personality> getPersonalities() {
        return personalities;
    }

    public void addPersonality(Personality personality) {
        personalities.add(personality);
    }


    //-------------Helpers--------------//

    @Override
    public String toString()
    {
        return hobbyN;
    }

}
