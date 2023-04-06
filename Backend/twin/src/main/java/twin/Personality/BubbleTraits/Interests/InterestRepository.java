package twin.Personality.BubbleTraits.Interests;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {

    Interest findById(long id);

    void deleteById(int id);
}
