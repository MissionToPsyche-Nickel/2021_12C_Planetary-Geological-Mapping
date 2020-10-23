/*********************************************************************************/
/**                                                                             **/
/**This file is responsible for controlling the error view.                     **/
/**When the site runs into an issue this controller displays the error view.    **/
/**Hiding the stack trace from the error.                                       **/
/**                                                                             **/
/** Last modified 10/23/2020  by James Lanham jrl5748@psu.edu                   **/
/*********************************************************************************/

package planetarymapping.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController implements ErrorController {

    private static final String PATH = "/error";

    @Override
    public String getErrorPath() {
        return PATH;
    }

    //Displaying the error view
    @RequestMapping("/error")
    public String error(){
        return "error";
    }
}
