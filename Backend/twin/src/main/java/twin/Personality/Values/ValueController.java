package twin.Personality.Values;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ValueController
{

    @Autowired
    private ValueRepository valueRepo;


    //-------------------------GET---------------------------------//

    @GetMapping("/value")
    public List<Value> returnValues() { return valueRepo.findAll(); }

    @GetMapping("/value/{id}")
    public Value getValueById(@PathVariable int id){return valueRepo.findById(id);}

    //-------------------------POST--------------------------------//

    @PostMapping("/value/{name}")
    public Value createValue(@PathVariable String name) {
        if(name == null || name.equals(""))
            return null;
        Value v = new Value(name);
        return valueRepo.save(v);
    }

    //-------------------------Delete-------------------------------//

    @DeleteMapping("/value/{id}")
    public @ResponseBody void removeValue(@PathVariable Long id) { valueRepo.deleteById(id); }
}
