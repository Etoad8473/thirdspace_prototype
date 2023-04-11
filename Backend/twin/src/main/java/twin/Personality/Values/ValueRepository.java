package twin.Personality.Values;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValueRepository extends JpaRepository<Value, Long>
{
    Value findById(long id);

    void deleteById(int id);
}
