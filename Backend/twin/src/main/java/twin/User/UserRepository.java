package twin.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import twin.User.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    User findById(long id);

    void deleteById(int id);

}