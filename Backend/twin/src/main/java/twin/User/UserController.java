package twin.User;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import twin.Personality.Personality;

import java.util.List;

@RestController
class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/user")
    public List<User> returnUsers(){
        return userRepo.findAll();
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userRepo.save(user);
    }

    @PostMapping("/user/{id}/personality")
    public User updatePersonality(@PathVariable long id, @RequestBody Personality personality)
    {
        User u = userRepo.getOne(id);
        u.setPersonality(personality);
        return u;
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


    @DeleteMapping("/user/{id}")
    public @ResponseBody void removePerson(@PathVariable Long id){
        userRepo.deleteById(id);
    }
}