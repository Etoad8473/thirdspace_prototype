package twin.User;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import twin.Personality.Personality;
import twin.Personality.PersonalityRepository;

import java.util.List;

@RestController
class UserController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PersonalityRepository personalityRepo;


    //-----------------------------GET---------------------//

    @GetMapping("/user")
    public List<User> returnUsers(){
        return userRepo.findAll();
    }

    //----------------------------POST----------------------//

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userRepo.save(user);
    }

    @PostMapping("/user/{id}")
    public User updateUserById(@PathVariable long id, @RequestBody User updatedU)
    {
        User current = userRepo.findById(id);
        current = updatedU;
        userRepo.save(current);

        return current;
    }

    @PostMapping("/user/{uId}/personality/{pId}")
    public String setPersonality(@PathVariable long uId, @PathVariable long pId)
    {
        User u = userRepo.findById(uId);
        Personality p = personalityRepo.findById(pId);

        if(u==null||p==null)
        {
            return "failed updating personality: couldn't find personality or couldn't find user";
        }

        p.setUser(u);
        u.setPersonality(p);
        userRepo.save(u);

        return "successfully set User's Personality";
    }

    //---------------------------Delete-----------------------//

    @DeleteMapping("/user/{id}")
    public @ResponseBody void removePerson(@PathVariable Long id){
        userRepo.deleteById(id);
    }

        /*@GetMapping("/user/{name}")
    public @ResponseBody String getUser(@PathVariable String name)
    {
        User user = userList.get(name);
        return user.toString();
    }*/

    /*@GetMapping("/user/{name}/friends")
    public @ResponseBody String getUsersFriends(@PathVariable String name)
    {
        User user = userList.get(name);
        ArrayList userFriends = new ArrayList<User>();

        for(String i: userList.keySet())
        {
            if (user.getUserName() != i) {
                if (user.getPersonality() == userList.get(i).getPersonality()) {
                    userFriends.add(userList.get(i));
                }
            }
        }

        return user.toString() +"\n\n"+ userFriends;
    }*/

}