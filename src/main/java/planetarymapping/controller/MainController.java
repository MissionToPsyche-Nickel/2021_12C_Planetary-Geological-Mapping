/*********************************************************************************/
/**                                                                             **/
/**This file is responsible for controlling views that are not the map and the  **/
/**user does not need to be authenticated to use.                               **/
/**This is where the user can login, register and view the home page            **/
/**                                                                             **/
/** Last modified 10/23/2020  by James Lanham jrl5748@psu.edu                   **/
/*********************************************************************************/

package planetarymapping.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import planetarymapping.Repository.AuthoritiesRepository;
import planetarymapping.Repository.UserRepository;
import planetarymapping.model.UserAuthorities;
import planetarymapping.model.Users;

@Controller
public class MainController {

    //Password encoder declaration
    private PasswordEncoder passwordEncoder;

    //User repository declaration
    private UserRepository userRepository;

    //User Authorities repository declaration
    private AuthoritiesRepository authoritiesRepository;

    //Constructor injecting the needed fields
    public MainController(PasswordEncoder passwordEncoder, UserRepository userRepository, AuthoritiesRepository authoritiesRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authoritiesRepository = authoritiesRepository;
    }

    //Displaying home view at root
    @GetMapping("/")
    public String althome(){
        return "home";
    }

    //Displaying home view at /home
    @GetMapping("/home")
    public String home(){
        return "home";
    }

    //Displaying the login view
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    //Displaying register view
    @GetMapping("/register")
    public String register(){
        return "register";
    }

    //Registering new users
    @PostMapping("/register")
    public String doRegister(@RequestParam String userName, String password, String auth) {
        String encodedPassword  = passwordEncoder.encode(password);

        Users user = new Users(userName);
        user.setEnabled(Boolean.TRUE);
        user.setPassword(encodedPassword);
        userRepository.save(user);
        Long id = user.getId();
        UserAuthorities authorities = new UserAuthorities(id, auth);
        authoritiesRepository.save(authorities);

        return "login";
    }
}
