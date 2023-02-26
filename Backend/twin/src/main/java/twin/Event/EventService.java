package twin.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService implements EventServiceOutline {

    @Autowired
    private EventRepository eventRepo;

    @Override
    public Event saveEvent(Event event) { return eventRepo.save(event); }

    @Override
    public List<Event> getEventList() { return eventRepo.findAll(); }

    @Override
    public void deleteEvent(Long id) { eventRepo.deleteById(id); }

}
