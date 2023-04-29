package twin.Group;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import twin.User.User;

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

    @PostMapping("/group/addUser")
    public Group addUser(@RequestBody Group group, User user) {
        group.addUser(user);
        return groupRepo.save(group);
    }

    //-------------------------Delete-------------------------------//
    @DeleteMapping("/group/{id}")
    public @ResponseBody void removeGroup(@PathVariable Long id) { groupRepo.deleteById(id); }

}
