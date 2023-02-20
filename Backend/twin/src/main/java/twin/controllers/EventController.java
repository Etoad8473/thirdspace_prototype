package twin.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import twin.models.Event;
import twin.repositories.EventRepository;
import twin.services.EventService;
import twin.services.EventServiceAbstract;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventServ;

    @GetMapping("/event")
    public List<Event> returnEvents() { return eventServ.getEventList(); }

    @PostMapping("/event")
    public Event createEvent(@RequestBody Event event) { return eventServ.saveEvent(event); }

    @DeleteMapping("/event/{id}")
    public @ResponseBody void removeEvent(@PathVariable Long id) { eventServ.deleteEvent(id); }
}
