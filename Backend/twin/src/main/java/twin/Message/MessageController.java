package twin.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twin.User.User;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    private MessageRepository messageRepo;

    @GetMapping("/message")
    public List<Message> returnMessages(){
        return messageRepo.findAll();
    }

    @GetMapping("/message/{id}")
    public Message getMessageById(@PathVariable int id){
        return messageRepo.findById(id);
    }

    @PostMapping("/message")
    public Message createMessage(@RequestBody Message message) { return messageRepo.save(message); }

    @DeleteMapping("/message/{id}")
    public @ResponseBody void removeMessage(@PathVariable Long id) { messageRepo.deleteById(id); }
}
