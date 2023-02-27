package twin.User;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import twin.Hobby.Hobby;
import twin.Hobby.HobbyRepository;
import twin.Personality.Personality;
import twin.Personality.PersonalityRepository;

import java.util.List;
import java.util.Optional;

@RestController
class UserController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PersonalityRepository personalityRepo;

    @Autowired
    private HobbyRepository hobbyRepo;


    //-----------------------------GET---------------------//

    @GetMapping("/user/getAll")
    public List<User> returnUsers(){
        return userRepo.findAll();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id){ return userRepo.findById(id);}

    @GetMapping("/user/{uId}/hobby/getAll")
    public String returnHobbyListString(@PathVariable long uId)
    {
        User u = userRepo.findById(uId);

        if(u != null)
            return u.getPersonality().toString();
        else
            return "user not found";
    }

    //----------------------------POST----------------------//

    @PostMapping("/user/new")
    public User createUser(@RequestBody User user){
        return userRepo.save(user);
    }

    @PostMapping("/user/{id}/update")
    public User updateUserById(@PathVariable long id, @RequestBody User updatedU)
    {
        User current = userRepo.findById(id);
        current = updatedU;
        userRepo.save(current);

        return current;
    }

    @PostMapping("/user/{uId}/hobby/add/{hId}")
    public boolean addHobby(@PathVariable long uId, @PathVariable long hId)
    {
        User u = userRepo.findById(uId);
        Personality p = u.getPersonality();
        Hobby h = hobbyRepo.findById(hId);

        //personalityRepo.save(p);
        //hobbyRepo.save(h);

        return p.addHobby(h);
    }

    /*
    @PostMapping("/user/{uId}/personality")
    public String addPersonality(@PathVariable long uId, @PathVariable long pId)
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
    */

    //---------------------------Delete-----------------------//

    @DeleteMapping("/user/{id}/delete")
    public @ResponseBody void removePerson(@PathVariable long id){
        ;
        personalityRepo.deleteById(userRepo.findById(id).getPersonality().getId());
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