package twin.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twin.User.User;

import java.util.List;

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

    @PostMapping("message/{name}")
    public Message createMessage(@PathVariable String data, String date, String time, User sender){
        if(data == null || data.equals("")){
            return null;
        }

        if(date == null || date.equals("")){
            return null;
        }

        if(time == null || time.equals("")){
            return null;
        }

        if(sender == null){
            return null;
        }
        Message message = new Message(data, date, time, sender);
        return messageRepo.save(message);
    }

    @DeleteMapping("/message/{id}")
    public @ResponseBody void removeMessage(@PathVariable Long id) { messageRepo.deleteById(id); }
}
