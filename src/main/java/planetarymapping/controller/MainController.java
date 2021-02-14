/*********************************************************************************/
/**                                                                             **/
/**This file is responsible for controlling views that are not the map and the  **/
/**user does not need to be authenticated to use.                               **/
/**This is where the user can login, register and view the home page            **/
/**                                                                             **/
/** Last modified 10/23/2020  by James Lanham jrl5748@psu.edu                   **/
/*********************************************************************************/

package planetarymapping.controller;

//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import planetarymapping.Repository.MapRepository;
import planetarymapping.model.Maps;
import planetarymapping.service.MapService;

@Controller
public class MainController {

    //Password encoder declaration
    //private PasswordEncoder passwordEncoder;

    @Autowired
    private MapRepository mapRepository;

    @Autowired
    private MapService mapService;

    //User repository declaration
//    @Autowired
//    private UserRepository userRepository;
//
//    //User Authorities repository declaration
//    @Autowired
//    private AuthoritiesRepository authoritiesRepository;

    //Constructor injecting the needed fields
//    public MainController( UserRepository userRepository, AuthoritiesRepository authoritiesRepository) {
//        /*PasswordEncoder passwordEncoder,
//        this.passwordEncoder = passwordEncoder;*/
//        this.userRepository = userRepository;
//        this.authoritiesRepository = authoritiesRepository;
//    }

    //Displaying home view at root
    @GetMapping("/")
    public String althome(){
        return "index";
    }

    //Displaying home view at /home
    @GetMapping("/home")
    public String home(){
        return "index";
    }

    @GetMapping("/geologic-mapping")
    public String events(){
        return "geologic-mapping";
    }

    @RequestMapping("/map/{mapName}")
    public String viewFromDbTemplate(@PathVariable String mapName) {

        if (mapName.equals("nav")) {
            return "maps";
        }
        return "db-map-" + mapName;
    }
}
