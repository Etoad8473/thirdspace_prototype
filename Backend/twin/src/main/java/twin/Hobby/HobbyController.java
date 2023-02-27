package twin.Hobby;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HobbyController
{

    @Autowired
    private HobbyRepository hobbyRepo;


    //-------------------------------GET--------------------------//

    @GetMapping("/hobby/getAll")
    public List<Hobby> returnHobbies() { return hobbyRepo.findAll(); }

    @GetMapping("/hobby/{id}")
    public Hobby getHobbyById(@PathVariable int id){ return hobbyRepo.findById(id);};

    //------------------------------POST----------------------------//

    @PostMapping("/hobby/{name}")
    public Hobby createHobby (@PathVariable String name) {
        return hobbyRepo.save(new Hobby(name));
    }

    //------------------------------Delete-------------------------//

    @DeleteMapping("/hobby/{id}")
    public @ResponseBody void removeHobby(@PathVariable Long id) { hobbyRepo.deleteById(id); }
}
