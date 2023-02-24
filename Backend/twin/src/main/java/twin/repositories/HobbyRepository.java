package twin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import twin.entities.Event;
import twin.entities.Hobby;

@Repository
public interface HobbyRepository extends JpaRepository<Hobby, Long> {}

