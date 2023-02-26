package twin.Personality;

import twin.Personality.Personality;

public interface PersonalityServiceOutline {

    Personality savePersonality(Personality p);

    void updatePersonality(Long id, Personality p);

}
