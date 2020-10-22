package planetarymapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import planetarymapping.Repository.UserRepository;
import planetarymapping.model.User;

@Controller
public class RegisterController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String doRegister(@RequestParam String userName, String password, int roll) {
        String encodedPassword  = passwordEncoder.encode(password);

        User user = new User(userName);
        user.setEnabled(Boolean.TRUE);
        user.setPassword(encodedPassword);
        user.setRoll(roll);

        userRepository.save(user);

        return "home";
    }
}

