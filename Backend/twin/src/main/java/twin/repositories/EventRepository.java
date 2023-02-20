package twin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import twin.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {}

