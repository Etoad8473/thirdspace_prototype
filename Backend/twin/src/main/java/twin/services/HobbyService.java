package twin.services;

import org.springframework.beans.factory.annotation.Autowired;
import twin.entities.Event;
import twin.entities.Hobby;
import twin.repositories.HobbyRepository;
import twin.repositories.UserRepository;

import java.util.List;

public class HobbyService implements HobbyServiceOutline{

    @Autowired
    private HobbyRepository hobbyRepo;


    @Override
    public Hobby saveHobby(Hobby hobby) {
        return hobbyRepo.save(hobby);
    }

    @Override
    public List<Hobby> getHobbyList() {
        return hobbyRepo.findAll();
    }

    @Override
    public void deleteHobby(Long id) {
        hobbyRepo.deleteById(id);
    }

}
