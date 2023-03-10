package twin.Interests;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import twin.Event.Event;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {

    Interest findById(long id);

    void deleteById(int id);
}
