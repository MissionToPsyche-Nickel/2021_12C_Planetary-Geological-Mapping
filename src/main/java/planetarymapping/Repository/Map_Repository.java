package planetarymapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import planetarymapping.model.Map;

import java.util.List;

@Repository
public interface Map_Repository extends JpaRepository<Map, Integer> {
   List<Map> findAll();

   Map findAllById(Integer id);
}
