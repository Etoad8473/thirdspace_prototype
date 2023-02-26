package twin.Personality;

import twin.User.User;
import twin.Hobby.Hobby;

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

    public void addHobby(Hobby h){hobbies.add(h);}


}
