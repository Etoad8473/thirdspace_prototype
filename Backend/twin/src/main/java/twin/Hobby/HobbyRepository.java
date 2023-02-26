package twin.Hobby;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import twin.Hobby.Hobby;
import twin.User.User;

@Repository
public interface HobbyRepository extends JpaRepository<Hobby, Long>
{
    Hobby findById(long id);

    void deleteById(int id);
}

