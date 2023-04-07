package twin.Personality.Interests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import twin.Personality.Personality;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="interest")
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name = "interest_name")
    private String interestN;




    //----------Relations---------------//
    //@ManyToOne
    @ManyToMany
    @JsonIgnore
    private List<Personality> personalities;

    //----------Constructor-------------//

    public Interest(){
        personalities = new ArrayList<Personality>();
    }

    public Interest(String name)
    {
        personalities = new ArrayList<Personality>();
        this.interestN = name;
    }


    public String getInterestN() {
        return interestN;
    }

    public void setInterestN(String interestN) {
        this.interestN = interestN;
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
        return interestN;
    }
}

