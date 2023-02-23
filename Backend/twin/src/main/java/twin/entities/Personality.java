package twin.entities;

import javax.persistence.*;
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

    @OneToMany
    private List<Hobby> hobbies;


}
