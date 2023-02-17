package twin.services;

import java.util.List;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twin.models.User;

@Service
public interface UserService  {
    //Save
    User saveUser(User user);

    //Get all
    List<User> getUserList();

    //Update
    //User updateUser(User user, Long id);

    //Delete
    void deleteUser(Long id);

}
