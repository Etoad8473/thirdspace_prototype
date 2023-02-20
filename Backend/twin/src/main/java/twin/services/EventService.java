package twin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twin.entities.Event;
import twin.repositories.EventRepository;
import java.util.List;

@Service
public class EventService implements EventServiceAbstract {

    @Autowired
    private EventRepository eventRepo;

    @Override
    public Event saveEvent(Event event) { return eventRepo.save(event); }

    @Override
    public List<Event> getEventList() { return eventRepo.findAll(); }

    @Override
    public void deleteEvent(Long id) { eventRepo.deleteById(id); }

}
