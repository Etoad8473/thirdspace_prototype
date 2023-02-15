package twin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import twin.models.User;

public interface UserRepository extends JpaRepository<User, Long> {}
