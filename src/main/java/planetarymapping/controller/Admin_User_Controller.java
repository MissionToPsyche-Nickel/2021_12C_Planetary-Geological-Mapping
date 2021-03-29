package planetarymapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import planetarymapping.Repository.AccordionRepository;
import planetarymapping.Repository.User_Repository;
import planetarymapping.model.Accordion;
import planetarymapping.model.User;

import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class Admin_User_Controller {

    @Autowired
    User_Repository userRepo;

    /*Accordion Admin*/
    @GetMapping("")
    public String accordion(Model model){
        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "admin/user/admin-user";
    }

    @GetMapping("/add")
    public String accordionAdd(){
        return "admin/user/admin-user-add";
    }

    @PostMapping("/add")
    public String accordionAdded(Model model, @RequestParam("userName") String userName,
                                 @RequestParam("password") String password){

        User user = new User(userName, password);
        userRepo.save(user);

        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "admin/user/admin-user";
    }

    @GetMapping("/edit/{id}")
    public String accordionEdit(@PathVariable int id, Model model){

        User user = userRepo.findAllById(id);
        userRepo.deleteById(id);
        model.addAttribute("user", user);
        return "admin/user/admin-user-edit";
    }

    @PostMapping("/edit/{id}")
    public String accordionEdited(Model model, @RequestParam("userName") String userName,
                                  @RequestParam("password") String password){

        User user = new User(userName, password);
        userRepo.save(user);

        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "admin/user/admin-user";
    }

    @GetMapping("/delete/{id}")
    public String accordionDelete(@PathVariable int id, Model model){

        User user = userRepo.findAllById(id);
        model.addAttribute("user", user);
        return "admin/user/admin-user-delete";
    }

    @PostMapping("/delete/{id}")
    public String accordionDeleted(Model model,@PathVariable int id){

        userRepo.deleteById(id);

        List<User> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "admin/user/admin-user";
    }
}
