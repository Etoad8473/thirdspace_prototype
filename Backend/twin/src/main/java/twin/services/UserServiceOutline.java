package twin.services;

import java.util.List;

import org.springframework.stereotype.Service;
import twin.entities.Personality;
import twin.entities.User;

@Service
public interface UserServiceOutline {
    //Save
    User saveUser(User user);

    //Get all
    List<User> getUserList();

    //Update
    //User updateUser(User user, Long id);

    //Delete
    void deleteUser(Long id);

    User updatePersonality(long id, Personality personality);

}
