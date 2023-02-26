package twin.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import twin.Event.Event;
import twin.Hobby.Hobby;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>
{

    Event findById(long id);

    void deleteById(int id);
}

