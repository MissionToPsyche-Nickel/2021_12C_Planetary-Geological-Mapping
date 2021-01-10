/*********************************************************************************/
/**                                                                             **/
/**This file is responsible for controlling the user view.                      **/
/**For now, this only displays the user's username                              **/
/**                                                                             **/
/** Last modified 10/23/2020  by James Lanham jrl5748@psu.edu                   **/
/*********************************************************************************/

package planetarymapping.controller;

//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import planetarymapping.Repository.AuthoritiesRepository;
import planetarymapping.Repository.UserRepository;

@Controller
@RequestMapping("/user")        //Everything involving the user has the user mapping before it
public class UserController {

        //Password encoder declaration
       // private PasswordEncoder passwordEncoder;

        //User repository declaration
        private UserRepository userRepository;

        //User Authorities repository declaration
        private AuthoritiesRepository authoritiesRepository;

        //Constructor injecting the needed fields
        UserController( UserRepository userRepository, AuthoritiesRepository authoritiesRepository) {
                /*PasswordEncoder passwordEncoder,
                this.passwordEncoder = passwordEncoder;*/
                this.userRepository = userRepository;
                this.authoritiesRepository = authoritiesRepository;
        }




}
