package twin.Hobby;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import twin.Hobby.Hobby;

@Repository
public interface HobbyRepository extends JpaRepository<Hobby, Long> {}

