package twin.Hobby;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HobbyService implements HobbyServiceOutline {

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
