package twin.Hobby;

import twin.Hobby.Hobby;

import java.util.List;

public interface HobbyServiceOutline {

    Hobby saveHobby(Hobby hobby);

    List<Hobby> getHobbyList();

    void deleteHobby(Long id);

}
