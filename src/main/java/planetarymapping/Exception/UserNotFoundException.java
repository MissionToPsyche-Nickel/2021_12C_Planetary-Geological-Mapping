/*********************************************************************************/
/**                                                                             **/
/**This file is responsible for creating the UserNotFoundException              **/
/**                                                                             **/
/** Last modified 10/23/2020  by James Lanham jrl5748@psu.edu                   **/
/*********************************************************************************/

package planetarymapping.Exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id) {
        super("Could not find user " + id);
    }
}
