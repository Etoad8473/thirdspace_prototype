package twin.controllers;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import twin.models.User;
import twin.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/user")
    public List<User> returnUsers(){return userRepo.findAll();}

    @PostMapping("/user")
    public User createUser(@RequestBody User user)
    {
        return userRepo.save(user);
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


    /*@DeleteMapping("/user/{name}")
    public @ResponseBody String removePerson(@PathVariable String name)
    {
        String out = "Before:\n" + userList.toString();
        userList.remove(name);
        return out + "\n\n\nAfter:\n" + userList.toString();
    }*/
}