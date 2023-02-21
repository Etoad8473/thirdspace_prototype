package twin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name = "name")
    private String eventName;

    @Column(name = "location")
    private String location;

    @Column(name = "time")
    private String eventTime;

    public Event() {}

    //Creates an Event Object
    public Event(String eventName, String location, String eventTime){
        this.eventName = eventName;
        this.location = location;
        this.eventTime = eventTime;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventName=" + eventName +
                ", location='" + location + '\'' +
                ", Time='" + eventTime + '\'' +
                '}';
    }

    //returns the event's name
    public String getEventName(){
        return eventName;
    }

    //sets the event's name to a given string name
    public void setEventName(String name){
        eventName = name;
    }

    //returns the event location
    public String getLocation(){
        return location;
    }

    //sets the event location to a given string location.
    public void setLocation(String location){
        this.location = location;
    }

    //returns the time of the event
    public String getTime(){
        return eventTime;
    }

    //sets the time of the event to a given string time
    public void setTime(String time){
        eventTime = time;
    }
}
