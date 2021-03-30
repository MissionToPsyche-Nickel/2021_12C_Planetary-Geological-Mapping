package planetarymapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import planetarymapping.model.Map2d;

import java.util.List;

@Repository
public interface Map2d_Repository extends JpaRepository<Map2d, Integer> {
   List<Map2d> findAll();

   Map2d findAllById(Integer id);
}
