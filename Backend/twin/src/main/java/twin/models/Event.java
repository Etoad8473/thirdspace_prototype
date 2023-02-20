package twin.models;

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

    public String getEventName(){
        return eventName;
    }

    public void setEventName(String name){
        eventName = name;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getTime(){
        return eventTime;
    }

    public void setTime(String time){
        eventTime = time;
    }
}
