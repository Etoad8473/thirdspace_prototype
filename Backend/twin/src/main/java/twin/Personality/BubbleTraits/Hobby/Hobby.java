package twin.Personality.BubbleTraits.Hobby;

import com.fasterxml.jackson.annotation.JsonIgnore;
import twin.Personality.BubbleTraits.AbsBubbleTrait;
import twin.Personality.Personality;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Hobbies")
public class Hobby extends AbsBubbleTrait {

    public Hobby(){super();}
    public Hobby(String name){super(name);}

}
