package savantly.sprout.repositories;

import java.util.UUID;

import savantly.sprout.domain.Tree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreeRepository extends JpaRepository<Tree, UUID>{

}
