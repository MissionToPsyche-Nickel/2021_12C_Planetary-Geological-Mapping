package planetarymapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import planetarymapping.model.Users;

import java.util.List;

@Repository
public interface User_Repository extends JpaRepository<Users, Integer> {
   List<Users> findAll();

   Users findAllById(Integer id);
}
