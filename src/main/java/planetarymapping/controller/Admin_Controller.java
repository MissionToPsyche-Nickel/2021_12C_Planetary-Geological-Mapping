package planetarymapping.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/admin")
public class Admin_Controller {

    //Displaying the admin home
    @GetMapping("")
    public String admin(){
        return "admin/admin-home";
    }

}
