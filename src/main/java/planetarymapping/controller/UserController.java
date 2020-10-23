package planetarymapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import planetarymapping.Repository.AuthoritiesRepository;
import planetarymapping.Repository.UserRepository;
import planetarymapping.model.UserAuthorities;
import planetarymapping.model.Users;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Controller
@RequestMapping("/user")
public class UserController {

        @Autowired
        PasswordEncoder passwordEncoder;

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private AuthoritiesRepository authoritiesRepository;     //Users repository decleration

        UserController(UserRepository userRepository, AuthoritiesRepository authoritiesRepository) {
                this.userRepository = userRepository;
                this.authoritiesRepository = authoritiesRepository;
        }

        //Displaying temp hello page
        @GetMapping("/")
        public String hello(){
                return "user";
        }


}
