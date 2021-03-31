package planetarymapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import planetarymapping.model.Map3d;

import java.util.List;

@Repository
public interface Map3d_Repository extends JpaRepository<Map3d, Integer> {
   List<Map3d> findAll();

   Map3d findAllById(Integer id);
}
