package twin.Personality;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import twin.Personality.Personality;
import twin.User.User;

@Repository
public interface PersonalityRepository extends JpaRepository<Personality, Long>
{

    Personality findById(long id);

    void deleteById(int id);
}

