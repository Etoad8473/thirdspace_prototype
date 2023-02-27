package twin.Hobby;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HobbyController
{

    @Autowired
    private HobbyRepository hobbyRepo;

    @GetMapping("/hobby")
    public List<Hobby> returnHobbies() { return hobbyRepo.findAll(); }

    @GetMapping("/hobby/{id}")
    public Hobby getHobbyById(@PathVariable int id){ return hobbyRepo.findById(id);};

    @PostMapping("/hobby")
    public String createHobby (@RequestBody Hobby hobby) {
        hobbyRepo.save(hobby);
        return "saved hobby: " + hobby;
    }

    @DeleteMapping("/hobby/{id}")
    public @ResponseBody void removeHobby(@PathVariable Long id) { hobbyRepo.deleteById(id); }
}
