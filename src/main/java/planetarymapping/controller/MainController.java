package planetarymapping.controller;

import org.jboss.jandex.Main;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthoritiesRepository authoritiesRepository;     //Users repository decleration

    public MainController(UserRepository repository, UserRepository userRepository) {
        this.userRepository = repository;
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
