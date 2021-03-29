package planetarymapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import planetarymapping.model.User;

import java.util.List;

@Repository
public interface User_Repository extends JpaRepository<User, Integer> {
   List<User> findAll();

   User findAllById(Integer id);
}
