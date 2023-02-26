package twin.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twin.Personality.Personality;

import java.util.List;

@Service
public class UserService implements UserServiceOutline
{

    @Autowired
    private UserRepository userRepo;

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getUserList() {
        return userRepo.findAll();
    }

    /*@Override
    public User updateUser(User user, Long id) {
        User DBuser = userRepo.findById(id).get();
    }*/

    @Override
    public void deleteUser(Long id)
    {
        userRepo.deleteById(id);
    }

    @Override
    public User updatePersonality(long id, Personality personality) {
        User u = userRepo.getOne(id);
        u.setPersonality(personality);
        return u;
    }
}
