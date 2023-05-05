package twin.Group;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import twin.GroupChat.GroupChat;
import twin.GroupChat.GroupChatRepository;
import twin.Message.Message;
import twin.Personality.Hobby.Hobby;
import twin.Personality.Interests.Interest;
import twin.User.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;


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

    @GetMapping("/group/{id}/suggestActivity")
    public String suggestActivity(@PathVariable long id)
    {
        Group g = groupRepo.findById(id);

        ArrayList<Hobby> activities = new ArrayList<Hobby>();

        for(User u: g.getUsers())
        {
            activities.addAll(u.getPersonality().getHobbies());
        }

        Random rand = new Random();

        Hobby suggestion = activities.get(rand.nextInt(activities.size()));

        return "SUGGESTED ACTIVITY: " + suggestion.getHobbyN() +"\nWhen is everyone available?";
    }

    @GetMapping("/group/{id}/suggestConversation")
    public String suggestConversation(@PathVariable long id)
    {
        Group g = groupRepo.findById(id);

        ArrayList<Interest> conversationInterests = new ArrayList<Interest>();

        for(User u: g.getUsers())
        {
            conversationInterests.addAll(u.getPersonality().getInterests());
        }

        Random rand = new Random();

        if(conversationInterests.size()>0)
        {
            Interest suggestion = conversationInterests.get(rand.nextInt(conversationInterests.size()));
            return "SUGGESTED CONVERSATION: What are your thoughts on " + suggestion.getInterestN() +"?";
        }
        else
            return "No common interests";
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
