package twin.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Hobbies")
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    private String name;

    //----------Relations---------------//
    @ManyToOne
    private Personality personality;

    //----------Constructor-------------//

    protected Hobby(){}

    public Hobby(String name)
    {
        this.name = name;
    }

    /*@ManyToOne
    private Hobby parentHobby;
    @OneToMany
    private List<Hobby> subHobbies;
    */



}
