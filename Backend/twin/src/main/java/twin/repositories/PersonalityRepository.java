package twin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import twin.entities.Event;
import twin.entities.Personality;

@Repository
public interface PersonalityRepository extends JpaRepository<Personality, Long> {}

