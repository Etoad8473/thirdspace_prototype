package twin.Personality.Hobby;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HobbyRepository extends JpaRepository<Hobby, Long>
{
    Hobby findById(long id);

    void deleteById(int id);
}

