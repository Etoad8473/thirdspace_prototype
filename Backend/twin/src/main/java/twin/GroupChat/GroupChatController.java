package twin.GroupChat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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


}
