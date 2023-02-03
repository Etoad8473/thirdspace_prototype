package coms309.controllers;


import coms309.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
class UserController {

    HashMap<String, User> userList = new HashMap<>();


    @GetMapping("/user")
    public HashMap<String, User> returnUsers(){return userList;}

    @PostMapping("/user")
    public String createUser(@RequestBody User user)
    {
        User bob = user;
        userList.put(user.getUserName(), user);
        return "new user:\n" + bob;
    }

    @GetMapping("/user/{name}")
    public @ResponseBody String getUser(@PathVariable String name)
    {
        User user = userList.get(name);
        return user.toString();
    }

    @GetMapping("/user/{name}/friends")
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
    }


    @DeleteMapping("/user/{name}")
    public @ResponseBody String removePerson(@PathVariable String name)
    {
        String out = "Before:\n" + userList.toString();
        userList.remove(name);
        return out + "\n\n\nAfter:\n" + userList.toString();
    }
}