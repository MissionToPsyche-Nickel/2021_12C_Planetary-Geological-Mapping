/*********************************************************************************/
/**                                                                             **/
/**This file is responsible for controlling the map view.                       **/
/**For now, this is a dummy page or place holder                                **/
/**                                                                             **/
/** Last modified 10/23/2020  by James Lanham jrl5748@psu.edu                   **/
/*********************************************************************************/

package planetarymapping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/map")
public class MapController {

    //Displaying the map view
    @GetMapping("/")
    public String map(){
        return "maps";
    }

    //Displaying the map view
    @GetMapping("/moon")
    public String moon(){
        return "moon";
    }

    //Displaying the map view
    @GetMapping("/mars")
    public String mars(){
        return "mars";
    }

    //Displaying the map view
    @GetMapping("/psyche")
    public String psyche(){
        return "psyche";
    }
}
