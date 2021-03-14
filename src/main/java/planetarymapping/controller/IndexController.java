/*********************************************************************************/
/**                                                                             **/
/**This file is responsible for controlling the error view.                     **/
/**When the site runs into an issue this controller displays the error view.    **/
/**Hiding the stack trace from the error.                                       **/
/**                                                                             **/
/** Last modified 10/23/2020  by James Lanham jrl5748@psu.edu                   **/
/*********************************************************************************/

package planetarymapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import planetarymapping.Repository.SlideRepository;
import planetarymapping.model.Slide;

import java.util.List;

@Controller
public class IndexController implements ErrorController {

    private static final String PATH = "/error";

    @Autowired
    SlideRepository slideRepo;

    @Override
    public String getErrorPath() {
        return PATH;
    }

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
