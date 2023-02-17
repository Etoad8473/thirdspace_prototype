package twin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import twin.models.User;
import twin.repositories.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService
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
}
