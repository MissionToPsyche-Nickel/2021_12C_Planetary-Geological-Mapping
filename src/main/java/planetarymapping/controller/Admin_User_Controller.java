package planetarymapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import planetarymapping.repository.User_Repository;
import planetarymapping.model.Users;

import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class Admin_User_Controller {

    //Injecting the User persistence object
    @Autowired
    User_Repository userRepo;

    //Injecting the password encoder bean
    @Autowired
    PasswordEncoder encoder;

    //Displaying the root user admin page
    @GetMapping("")
    public String user(Model model){
        List<Users> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "admin/user/admin-user";
    }

    //Displaying the add new user page
    @GetMapping("/add")
    public String userAdd(){
        return "admin/user/admin-user-add";
    }

    //Processing the new user
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

    //Displaying the user to edit
    @GetMapping("/edit/{id}")
    public String userEdit(@PathVariable int id, Model model){

        Users user = userRepo.findAllById(id);
        model.addAttribute("user", user);
        return "admin/user/admin-user-edit";
    }

    //Processing the edited user
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

    //Displaying the user to delete
    @GetMapping("/delete/{id}")
    public String userDelete(@PathVariable int id, Model model){

        Users user = userRepo.findAllById(id);
        model.addAttribute("user", user);
        return "admin/user/admin-user-delete";
    }

    //Processing the user to delete
    @PostMapping("/delete/{id}")
    public String userDeleted(Model model,@PathVariable int id){

        userRepo.deleteById(id);

        List<Users> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "admin/user/admin-user";
    }
}
