package planetarymapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import planetarymapping.model.Maps;

public interface MapRepository extends JpaRepository<Maps, Long> {
}
