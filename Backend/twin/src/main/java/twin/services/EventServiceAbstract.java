package twin.services;

import java.util.List;
import org.springframework.stereotype.Service;
import twin.entities.Event;


@Service
public interface EventServiceAbstract {

    Event saveEvent(Event event);

    List<Event> getEventList();

    void deleteEvent(Long id);
}
