package twin.GroupChat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twin.Event.Event;
import twin.Message.Message;
import twin.Message.MessageRepository;
import twin.User.User;

import java.util.List;

@RestController
public class GroupChatController {

    @Autowired
    private GroupChatRepository groupChatRepo;

    @Autowired
    private MessageRepository messageRepo ;

    @GetMapping("/groupChat")
    public List<GroupChat> returnGroupChats(){
        return groupChatRepo.findAll();
    }

    @GetMapping("/groupChat/{id}/message")
    public Message returnMessage(@PathVariable long id) { return messageRepo.findById(id);}

    @GetMapping("/groupChat/{id}/messages")
    public List<Message> returnGroupChatMessages(@PathVariable long id){
        GroupChat g = groupChatRepo.findById(id);
        return g.getMessages();
    }

    @GetMapping("/groupChat/{id}")
    public GroupChat getGroupChat(@PathVariable long id){ return groupChatRepo.findById(id);}

    @PostMapping("/groupChat")
    public GroupChat createGroupChat(@RequestBody GroupChat groupChat) { return groupChatRepo.save(groupChat); }
    @PostMapping("/groupChat/{id}/message")
    public GroupChat addingMessage(@PathVariable long id, @RequestBody Message m) {
        GroupChat g = groupChatRepo.findById(id);
        g.addMessage(m);

        messageRepo.save(m);
        return groupChatRepo.save(g);
    }


    @DeleteMapping("/groupChat/{id}")
    public @ResponseBody void removeGroupChat(@PathVariable Long id) { groupChatRepo.deleteById(id); }
}
