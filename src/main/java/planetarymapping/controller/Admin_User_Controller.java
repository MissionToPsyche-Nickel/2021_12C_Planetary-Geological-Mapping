package planetarymapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import planetarymapping.Repository.User_Repository;
import planetarymapping.model.Users;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class Admin_User_Controller {

    @Autowired
    User_Repository userRepo;

    @Autowired
    PasswordEncoder encoder;

    /*user Admin*/
    @GetMapping("")
    public String user(Model model){
        List<Users> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "admin/user/admin-user";
    }

    @GetMapping("/add")
    public String userAdd(){
        return "admin/user/admin-user-add";
    }

    @PostMapping("/add")
    public String userAdded(Model model, @RequestParam("userName") String userName,
                                 @RequestParam("password") String password){

        String encoded = encoder.encode(password);
        Users user = new Users(userName, encoded);
        userRepo.save(user);

        List<Users> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "admin/user/admin-user";
    }

    @GetMapping("/edit/{id}")
    public String userEdit(@PathVariable int id, Model model){

        Users user = userRepo.findAllById(id);
        model.addAttribute("user", user);
        return "admin/user/admin-user-edit";
    }

    @PostMapping("/edit/{id}")
    public String userEdited(@PathVariable int id, Model model, @RequestParam("userName") String userName,
                             @RequestParam("password") String password){

        Users user = userRepo.findAllById(id);

        user.setUserName(userName);
        user.setPassword(encoder.encode(password));

        userRepo.save(user);

        List<Users> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "admin/user/admin-user";
    }

    @GetMapping("/delete/{id}")
    public String userDelete(@PathVariable int id, Model model){

        Users user = userRepo.findAllById(id);
        model.addAttribute("user", user);
        return "admin/user/admin-user-delete";
    }

    @PostMapping("/delete/{id}")
    public String userDeleted(Model model,@PathVariable int id){

        userRepo.deleteById(id);

        List<Users> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "admin/user/admin-user";
    }
}
