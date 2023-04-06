package twin.GroupChat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GroupChatRepository extends JpaRepository<GroupChat, Long> {

    GroupChat findById(long id);

    void deleteById(int id);
}
