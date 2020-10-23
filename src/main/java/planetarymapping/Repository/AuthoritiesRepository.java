/*********************************************************************************/
/**                                                                             **/
/**This file is responsible for creating a repo for the user_authorities table  **/
/**Thanks to JPA and spring, there isn't much here                              **/
/**                                                                             **/
/** Last modified 10/23/2020  by James Lanham jrl5748@psu.edu                   **/
/*********************************************************************************/

package planetarymapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import planetarymapping.model.UserAuthorities;


public interface AuthoritiesRepository extends JpaRepository<UserAuthorities, Long> {
}
