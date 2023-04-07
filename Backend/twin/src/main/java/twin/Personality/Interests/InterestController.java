package twin.Personality.Interests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InterestController
{

    @Autowired
    private twin.Personality.Interests.InterestRepository interestRepo;


    //-------------------------GET---------------------------------//

    @GetMapping("/interest")
    public List<Interest> returnInterests() { return interestRepo.findAll(); }

    @GetMapping("/interest/{id}")
    public Interest getInterestById(@PathVariable int id){return interestRepo.findById(id);}

    //-------------------------POST--------------------------------//

    @PostMapping("/interest/{name}")
    public Interest createInterest(@PathVariable String name) {
        if(name == null || name.equals(""))
            return null;
        Interest i = new Interest(name);
        return interestRepo.save(i);
    }

    //-------------------------Delete-------------------------------//

    @DeleteMapping("/interest/{id}")
    public @ResponseBody void removeInterest(@PathVariable Long id) { interestRepo.deleteById(id); }
}
