package twin.Group;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class GroupController {

    @Autowired
    private GroupRepository groupRepo;

    //-------------------------GET---------------------------------//
    @GetMapping("/group")
    public List<Group> returnGroups() { return groupRepo.findAll(); }

    //-------------------------POST--------------------------------//
    @PostMapping("/group")
    public Group createGroup(@RequestBody Group group) { return groupRepo.save(group); }

    //-------------------------Delete-------------------------------//
    @DeleteMapping("/group/{id}")
    public @ResponseBody void removeGroup(@PathVariable Long id) { groupRepo.deleteById(id); }

}
