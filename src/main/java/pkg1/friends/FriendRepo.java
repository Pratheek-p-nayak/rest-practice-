package pkg1.friends;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepo extends JpaRepository<FriendEntity, Integer> {

}
