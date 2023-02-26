package twin.Hobby;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twin.Event.Event;
import twin.Event.EventService;

import java.util.List;

public class HobbyController
{

    @Autowired
    private HobbyRepository hobbyRepo;

    @GetMapping("/hobby")
    public List<Hobby> returnHobbies() { return hobbyRepo.findAll(); }

    @PostMapping("/hobby")
    public Hobby createHobby (@RequestBody Hobby hobby) { return hobbyRepo.save(hobby); }

    @DeleteMapping("/hobby/{id}")
    public @ResponseBody void removeHobby(@PathVariable Long id) { hobbyRepo.deleteById(id); }
}
