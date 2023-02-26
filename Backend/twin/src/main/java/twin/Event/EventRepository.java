package twin.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import twin.Event.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {}

