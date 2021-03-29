package planetarymapping.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("")
    public String admin(){
        return "admin/admin-home";
    }

}
