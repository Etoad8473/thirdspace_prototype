package twin.Personality.BubbleTraits.Interests;

import javax.persistence.*;

@Entity
@Table(name="interest")
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name = "interest")
    private String interest;


}

