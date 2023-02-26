package twin.Event;

import java.util.List;
import org.springframework.stereotype.Service;
import twin.Event.Event;


@Service
public interface EventServiceOutline {

    Event saveEvent(Event event);

    List<Event> getEventList();

    void deleteEvent(Long id);
}
