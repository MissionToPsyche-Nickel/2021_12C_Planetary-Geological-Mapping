package planetarymapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import planetarymapping.repository.Slide_Repository;
import planetarymapping.model.Slide;

import java.util.List;

@Controller
public class Index_Controller implements ErrorController {

    //Injecting the Slider persistence object
    @Autowired
    Slide_Repository slideRepo;

    //Overriding the base error path
    @Override
    public String getErrorPath() { return "/error"; }

    //Displaying the error view
    @GetMapping("/error")
    public String error(){
        return "public/error";
    }

    //Displaying home view at root
    @GetMapping("/")
    public String home(Model model){

        List<Slide> slides = slideRepo.findAll();
        model.addAttribute("slides", slides);
        return "public/index";
    }

}
