package twin.services;

import twin.entities.Event;
import twin.entities.Hobby;

import java.util.List;

public interface HobbyServiceOutline {

    Hobby saveHobby(Hobby hobby);

    List<Hobby> getHobbyList();

    void deleteHobby(Long id);

}
