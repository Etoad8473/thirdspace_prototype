package twin.Personality.Traits.Interests.Hobby;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HobbyController
{

    @Autowired
    private HobbyRepository hobbyRepo;


    //-------------------------------GET--------------------------//

    @GetMapping("/hobby")
    public List<Hobby> returnHobbies() { return hobbyRepo.findAll(); }

    @GetMapping("/hobby/{id}")
    public Hobby getHobbyById(@PathVariable int id){ return hobbyRepo.findById(id);};

    //------------------------------POST----------------------------//

    @PostMapping("/hobby/{name}")
    public Hobby createHobby (@PathVariable String name) {
        if(name == null || name.equals(""))
            return null;
        Hobby h = new Hobby(name);
        return hobbyRepo.save(h);
    }

    //------------------------------Delete-------------------------//

    @DeleteMapping("/hobby/{id}")
    public @ResponseBody void removeHobby(@PathVariable Long id) { hobbyRepo.deleteById(id); }
}
