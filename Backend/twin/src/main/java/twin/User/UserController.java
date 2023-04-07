package twin.User;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import twin.Personality.BubbleTraits.Hobby.Hobby;
import twin.Personality.BubbleTraits.Hobby.HobbyRepository;
import twin.Personality.BubbleTraits.Interests.Interest;
import twin.Personality.BubbleTraits.Interests.InterestRepository;
import twin.Personality.BubbleTraits.Values.Value;
import twin.Personality.BubbleTraits.Values.ValueRepository;
import twin.Personality.Personality;
import twin.Personality.PersonalityRepository;

import java.util.List;

@RestController
class UserController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PersonalityRepository personalityRepo;

    @Autowired
    private HobbyRepository hobbyRepo;

    @Autowired
    private InterestRepository interestRepo;

    @Autowired
    private ValueRepository valueRepo;


    //-----------------------------GET---------------------//

    @GetMapping("/users")
    public List<User> returnUsers(){
        return userRepo.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id){ return userRepo.findById(id);}

    @GetMapping("/users/{id}/hobby")
    public List<Hobby> returnHobbyListString(@PathVariable long id)
    {
        User u = userRepo.findById(id);

        return u.getPersonality().getHobbies();
    }

    @GetMapping("/users/{id}/interest")
    public List<Interest> returnInterestListString(@PathVariable long id)
    {
        User u = userRepo.findById(id);

        return u.getPersonality().getInterests();
    }

    @GetMapping("/users/{id}/value")
    public List<Value> returnValueListString(@PathVariable long id)
    {
        User u = userRepo.findById(id);

        return u.getPersonality().getValues();
    }

    @GetMapping("/users/login")
    public String loginUserWithPassword(@RequestBody User check)
    {

        String userName = check.getUserName();
        String password = check.getPassword();

        List<User> userList = userRepo.findAll();

        User dBUser = null;

        for(User u: userList)
        {
            if(userName.equals(u.getUserName()))
            {
                dBUser = u;
                break;
            }
        }

        if(dBUser == null)
            return "user not found";

        if(password.equals(dBUser.getPassword()))
            return "success";
        else
            return "incorrect password";
    }

    //----------------------------POST----------------------//

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        userRepo.save(user);
        personalityRepo.save(user.getPersonality());
        return user;
    }

    @PostMapping("/users/{id}")
    public User updateUserById(@PathVariable long id, @RequestBody User updatedU)
    {
        User user = userRepo.findById(id);

        userRepo.save(updatedU);

        return userRepo.findById(id);
    }

    @PostMapping("/users/{uId}/hobby/{hId}")
    public String addHobby(@PathVariable long uId, @PathVariable long hId)
    {
        User u = userRepo.findById(uId);
        Personality p = u.getPersonality();
        Hobby h = hobbyRepo.findById(hId);

        p.addHobby(h);

        personalityRepo.save(p);
        hobbyRepo.save(h);

        //return "success";
        return "finished";
    }

    @PostMapping("/users/{uId}/interest/{iId}")
    public String addInterest(@PathVariable long uId, @PathVariable long iId)
    {
        User u = userRepo.findById(uId);
        Personality p = u.getPersonality();
        Interest i = interestRepo.findById(iId);

        p.addInterest(i);

        personalityRepo.save(p);
        interestRepo.save(i);

        //return "success";
        return "finished";
    }

    @PostMapping("/users/{uId}/value/{vId}")
    public String addValue(@PathVariable long uId, @PathVariable long vId)
    {
        User u = userRepo.findById(uId);
        Personality p = u.getPersonality();
        Value v = valueRepo.findById(vId);

        p.addValue(v);

        personalityRepo.save(p);
        valueRepo.save(v);

        //return "success";
        return "finished";
    }


    //---------------------------Delete-----------------------//

    @DeleteMapping("/users/{id}")
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