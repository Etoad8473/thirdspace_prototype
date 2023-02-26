package twin.Personality;

import org.springframework.beans.factory.annotation.Autowired;

public class PersonalityService implements PersonalityServiceOutline {
    @Autowired
    PersonalityRepository personalityRepo;

    @Override
    public Personality savePersonality(Personality p) {
        return personalityRepo.save(p);
    }

    @Override
    public void updatePersonality(Long id, Personality p) {
        Personality old = personalityRepo.getOne(id);
        old = p;
    }
}
