package twin.Personality;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import twin.Personality.Personality;

@Repository
public interface PersonalityRepository extends JpaRepository<Personality, Long> {}

