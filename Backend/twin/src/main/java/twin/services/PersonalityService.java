package twin.services;

import org.springframework.beans.factory.annotation.Autowired;
import twin.entities.Personality;
import twin.repositories.PersonalityRepository;

public class PersonalityService implements PersonalityServiceOutline{
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
