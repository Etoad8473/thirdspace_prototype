package twin.Personality.BubbleTraits.Values;


import com.fasterxml.jackson.annotation.JsonIgnore;
import twin.Personality.Personality;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="value")
public class Value {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name = "value_name")
    private String valueN;




    //----------Relations---------------//
    //@ManyToOne
    @ManyToMany
    @JsonIgnore
    private List<Personality> personalities;

    //----------Constructor-------------//

    public Value(){
        personalities = new ArrayList<Personality>();
    }

    public Value(String name)
    {
        personalities = new ArrayList<Personality>();
        this.valueN = name;
    }


    public String getValueN() {
        return valueN;
    }

    public void setValueN(String valueN) {
        this.valueN = valueN;
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
        return valueN;
    }
}


