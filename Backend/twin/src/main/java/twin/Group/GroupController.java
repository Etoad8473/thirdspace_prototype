package twin.Group;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import twin.GroupChat.GroupChat;
import twin.GroupChat.GroupChatRepository;
import twin.Message.Message;
import twin.User.User;

import java.util.List;


@RestController
public class GroupController {

    @Autowired
    private GroupRepository groupRepo;

    @Autowired
    private GroupChatRepository groupChatRepo;

    //-------------------------GET---------------------------------//
    @GetMapping("/group")
    public List<Group> returnGroups() { return groupRepo.findAll(); }

    @GetMapping("/group/{id}")
    public Group returnGroup(@PathVariable long id) { return groupRepo.findById(id); }

    @GetMapping("/group/{id}/message")
    public List<Message> getGroupsMessages(@PathVariable long id)
    {
        return groupRepo.findById(id).getGroupChat().getMessages();
    }

    //-------------------------POST--------------------------------//
    @PostMapping("/group")
    public Group createGroup(@RequestBody Group group) { return groupRepo.save(group); }

//    @PostMapping("/group/{id}/addUser")
//    public Group addUser(@RequestBody Group group, User user) {
//        group.addUser(user);
//        return groupRepo.save(group);
//    }

    @PostMapping("/group/{id}/message")
    public GroupChat addMessageToGroupChat(@PathVariable long id, @RequestBody Message m)
    {
        GroupChat gc = groupRepo.findById(id).getGroupChat();

        gc.addMessage(m);

        return groupChatRepo.save(gc);
    }


    //-------------------------Delete-------------------------------//
    @DeleteMapping("/group/{id}")
    public @ResponseBody void removeGroup(@PathVariable Long id) { groupRepo.deleteById(id); }

}
