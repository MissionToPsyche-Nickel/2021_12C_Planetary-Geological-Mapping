/*********************************************************************************/
/**                                                                             **/
/**This file is responsible for creating a repo for the users table             **/
/**Thanks to JPA and spring, there isn't much here                              **/
/**                                                                             **/
/** Last modified 10/23/2020  by James Lanham jrl5748@psu.edu                   **/
/*********************************************************************************/

package planetarymapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import planetarymapping.model.Users;

//Decleration of UsersRepository, implements CrudRepository so the hard work is handled by that library
public interface UserRepository extends JpaRepository<Users, Long> {

}
