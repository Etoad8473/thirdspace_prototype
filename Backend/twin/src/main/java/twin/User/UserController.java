package twin.User;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import twin.Group.Group;
import twin.Group.GroupRepository;
import twin.Personality.Hobby.Hobby;
import twin.Personality.Hobby.HobbyRepository;
import twin.Personality.Interests.Interest;
import twin.Personality.Interests.InterestRepository;
import twin.Personality.Values.Value;
import twin.Personality.Values.ValueRepository;
import twin.Personality.Personality;
import twin.Personality.PersonalityRepository;

import javax.persistence.Column;
import java.util.*;

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

    @Autowired
    private GroupRepository groupRepo;


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

    @GetMapping("/users/{id}/friends")
    public List<User> returnFriends(@PathVariable long id)
    {
        User u = userRepo.findById(id);

        return u.getFriends();
    }

    @GetMapping("/users/login/{username}/{password}")
    public User loginUserWithPassword(@PathVariable String username, @PathVariable String password)
    {

        List<User> userList = userRepo.findAll();

        User userFound = null;

        //check if any users have the username
        for(User u: userList)
        {
            if(username.equals(u.getUserName()))
            {
                userFound = u;
                break;
            }
        }

        if(userFound == null)
            return null;

        if(password.equals(userFound.getPassword()))
            return userFound;
        else
            return null;
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

    @PostMapping("/users/{id}/createBestMatch")
    public String getMatchB(@PathVariable long id)
    {
        User u = userRepo.findById(id);

        //get users hobbies
        //for each hobby the user has
        //for each hobby, return all users with that hobby
        //check if in map

        //potential list, return the highest connection
        HashMap<Long, Integer> potential = new HashMap<Long, Integer>();

        List<Hobby> hobbies = u.getPersonality().getHobbies();
        for(Hobby h:hobbies)
        {
            List<Personality> personalities = h.getPersonalities();
            for(Personality p : personalities)
            {
                Long potentialID = p.getUser().getId();
                //skip this users own ID
                if(potentialID == id) continue;

                if(potential.containsKey(potentialID))
                    potential.put(potentialID, potential.get(potentialID) + 1);
                else
                    potential.put(potentialID, 1);
            }
        }


        //get the friend object from search
        Long friendId = Collections.max(potential.entrySet(), Map.Entry.comparingByValue()).getKey();
        User friend = userRepo.findById(friendId).get();


        //create a String list of the potentials to print
        String ratedFriends = "";
        for(Long hashID: potential.keySet())
        {
            //find the user in the repo
            User pot = userRepo.findById(hashID).get();

            //add their username and connection level to a string with \n
            String name = pot.getName();
            int connection = potential.get(hashID);

            ratedFriends += name + ": " + connection + "\n";
        }


        //check if friend already added
        if(u.getFriends().contains(friend))
            return "already added: " + friend.getName() + " from list:\n" + ratedFriends;
        else {
            //add friend
            u.addFriend(friend);

            userRepo.save(u);
            userRepo.save(friend);

            return "added: " + friend.getUserName() + " from list:\n" + ratedFriends;
        }
    }

    @PostMapping("/users/{id}/createRandMatch")
    public String getMatchR(@PathVariable Long id)
    {
        User u = userRepo.findById(id).get();

        Random rand = new Random();

        List<Hobby> hobbies = u.getPersonality().getHobbies();

        Hobby h = hobbies.get(rand.nextInt(hobbies.size()));
        List<Personality> persons = h.getPersonalities();
        User randFriend = persons.get(rand.nextInt(persons.size())).getUser();


        //check self reference
        if(randFriend.equals(u))
            return "self reference";

        //check if friend already added
        if(u.getFriends().contains(randFriend))
            return "already added: " + randFriend.getName();
        else
        {
            //add friends
            u.addFriend(randFriend);

            userRepo.save(u);
            userRepo.save(randFriend);

            return "added: " + randFriend.getUserName();
        }
    }


    @PostMapping("/users/{id}/createGroupMatchA")
    public String createGroupMatchFromSingleMatch(@PathVariable Long id)
    {

        //ABSTRACT: get match, find others



        return "fail";
    }


    @PostMapping("/users/{id}/createGroupMatchB")
    public String createGroupMatchB(@PathVariable Long id, @RequestBody Group g)
    {

        //ABSTRACT: get users hobbies, choose hobby with the most people, then randomly select people
        //TODO: make the selection random

        groupRepo.save(g);

        //get users hobbies
        User user = userRepo.findById(id).get();
        List<Hobby> hobbies = user.getPersonality().getHobbies();

        //choose hobby with the most people
        Hobby commonHobby = hobbies.get(0);
        for(Hobby h: hobbies)
        {
            if(h.getPersonalities().size() > commonHobby.getPersonalities().size())
                commonHobby = h;
        }
        int numOfProspects = commonHobby.getPersonalities().size();


        //select random people
        HashSet<User> prospects = new HashSet<User>();

        if(numOfProspects <= 1)//at least 2 prospects to make a group, return too few
            return "too few people with common hobbies";

        if(numOfProspects <= 3)//if there are 2-3 propects add them to group
        {
            for(Personality p: commonHobby.getPersonalities())
            {
                prospects.add(p.getUser());
            }
        }
        else//if there are >3 prospects, randomly choose 3
        {
            Random rand = new Random();//TODO
            //int skip = 0;//in order to skip self referential elements

            prospects.add(user);

            //for 4 people randomly select
            for(int i = 0; i<4; i++)
            {
                //TODO: make the selection random

                //make sure there's no self reference in prospects,, skip to next prospect if self reference
                //if(commonHobby.getPersonalities().get(i).getUser().getId() == id)
                //    skip=1;

                User addU = commonHobby.getPersonalities().get(i /*+ skip*/).getUser();
                prospects.add(addU);
                //System.out.println(addU);
            }
        }

        //create and fill group object
        String message = "";
        for(User u: prospects) {
            message += " " + u.getName();
        }
        //prospects.add(user);
        for(User u: prospects)
            g.addUser(u);

        //save to repo
        groupRepo.save(g);

        return "Created group for " + user.getName() + " with:" + message;
    }

    @PostMapping("/users/{uId}/group/{gId}")
    public String addUserToGroup(@PathVariable long uId, @PathVariable long gId)
    {
        User u = userRepo.findById(uId);
        Group g = groupRepo.findById(gId);

        g.addUser(u);
        groupRepo.save(g);

        return "Added user-"+u.getName()+":" +u.getId()+ " to group-" +g.getGroupName()+ ":"+g.getId();
    }


    @PostMapping("/users/{uId}/hobby/{hId}")
    public String addHobby(@PathVariable long uId, @PathVariable long hId)
    {
        User u = userRepo.findById(uId);
        Personality p = u.getPersonality();
        Hobby h = hobbyRepo.findById(hId);

        //check if hobby already exists
        if(u.getPersonality().getHobbies().contains(h))
            return "hobby already added";
        else
        {
            p.addHobby(h);

            personalityRepo.save(p);
            hobbyRepo.save(h);

            return "added hobby: " + h.getHobbyN() + "  to user: " + u.getName();
        }
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


        //add the same self checking functions from hobby

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

        //add the same self checking functions from hobby

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

}