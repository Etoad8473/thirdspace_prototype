package twin.GroupChat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twin.Event.Event;
import twin.User.User;

import java.util.List;

@RestController
public class GroupChatController {

    @Autowired
    private GroupChatRepository groupChatRepo;

    @GetMapping("/groupChats")
    public List<GroupChat> returnGroupChats(){
        return groupChatRepo.findAll();
    }

    @GetMapping("/groupChat/{id}")
    public GroupChat getGroupChat(@PathVariable long id){ return groupChatRepo.findById(id);}

    @PostMapping("/groupChat")
    public GroupChat createGroupChat(@RequestBody GroupChat groupChat) { return groupChatRepo.save(groupChat); }

    @DeleteMapping("/groupChat/{id}")
    public @ResponseBody void removeGroupChat(@PathVariable Long id) { groupChatRepo.deleteById(id); }
}
