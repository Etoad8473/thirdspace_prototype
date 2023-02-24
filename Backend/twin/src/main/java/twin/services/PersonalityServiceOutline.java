package twin.services;

import twin.entities.Event;
import twin.entities.Personality;
import twin.entities.User;

import java.util.List;

public interface PersonalityServiceOutline {

    Personality savePersonality(Personality p);

    void updatePersonality(Long id, Personality p);

}
