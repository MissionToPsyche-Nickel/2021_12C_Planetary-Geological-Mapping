package planetarymapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import planetarymapping.model.User;

//Decleration of UsersRepository, implements CrudRepository so the hard work is handled by that library
public interface UserRepository extends JpaRepository<User, Long> {

}
