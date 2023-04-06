package twin.Personality.BubbleTraits;

import com.fasterxml.jackson.annotation.JsonIgnore;
import twin.Personality.Personality;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbsBubbleTrait {

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

    public AbsBubbleTrait(){
        personalities = new ArrayList<Personality>();
    }

    public AbsBubbleTrait(String name)
    {
        personalities = new ArrayList<Personality>();
        this.hobbyN = name;
    }


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
