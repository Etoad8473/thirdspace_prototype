package twin.Personality;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twin.Hobby.Hobby;
import twin.Hobby.HobbyRepository;
import twin.Personality.PersonalityRepository;

import java.util.List;

@RestController
public class PersonalityController
{

    //--THIS IS ALL REDUNTANT, ALL CALLS MOVED TO USER CONTROLLER--//

    /*
    String failure = "failed";
    String success = "success";

    @Autowired
    private PersonalityRepository personalityRepo;

    @Autowired
    private HobbyRepository hobbyRepo;



    //-------------------------------GET---------------------------//

    @GetMapping("/personality")
    public List<Personality> returnPersonality() { return personalityRepo.findAll();}

    //-------------------------------POST--------------------------//

    @PostMapping("/personality")
    public Personality createPersonality (@RequestBody Personality personality) { return personalityRepo.save(personality); }

    @PostMapping("/personality/{pId}/hobby/{hId}")
    public String assignHobbyToPersonality(@PathVariable long pId, @PathVariable long hId)
    {
        Personality p = personalityRepo.findById(pId);
        Hobby h = hobbyRepo.findById(hId);
        if(p==null||h==null)
            return failure;

        h.addPersonality(p);
        p.addHobby(h);

        personalityRepo.save(p);
        return success + ", added " + h.toString() + " to personality: " + p.toString();
    }

    //-------------------------------Delete----------------------------//

    @DeleteMapping("/personality/{id}/")
    public @ResponseBody void removePersonality(@PathVariable Long id) { personalityRepo.deleteById(id); }

     */
}
