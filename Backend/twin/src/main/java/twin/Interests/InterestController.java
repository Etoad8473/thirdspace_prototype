package twin.Interests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twin.Event.Event;

import java.util.List;

@RestController
public class InterestController {

    //-------------------------GET---------------------------------//
    @Autowired
    private InterestRepository interestRepo;

    @GetMapping("/interest")
    public List<Interest> returnInterests() { return interestRepo.findAll(); }

    //-------------------------POST--------------------------------//
    public Interest createInterest(@RequestBody Interest interest) { return interestRepo.save(interest); }

    //-------------------------Delete-------------------------------//
    public @ResponseBody void removeInterest(@PathVariable Long id) { interestRepo.deleteById(id); }
}
