package planetarymapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import planetarymapping.model.Users;

//Decleration of UsersRepository, implements CrudRepository so the hard work is handled by that library
public interface UserRepository extends JpaRepository<Users, Long> {

}
