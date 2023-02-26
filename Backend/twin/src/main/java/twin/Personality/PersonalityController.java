package twin.Personality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twin.Hobby.Hobby;
import twin.Personality.PersonalityRepository;

import java.util.List;

public class PersonalityController
{

    @Autowired
    private PersonalityRepository personalityRepo;

    @GetMapping("/personality")
    public List<Personality> returnPersonality() { return personalityRepo.findAll();}

    @PostMapping("/personality")
    public Personality createPersonality (@RequestBody Personality personality) { return personalityRepo.save(personality); }

    @DeleteMapping("/personality/{id}")
    public @ResponseBody void removePersonality(@PathVariable Long id) { personalityRepo.deleteById(id); }
}
