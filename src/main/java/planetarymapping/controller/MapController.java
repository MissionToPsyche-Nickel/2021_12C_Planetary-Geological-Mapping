package planetarymapping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MapController {

    @RequestMapping("/map/{mapName}")
    public String viewFromDbTemplate(@PathVariable String mapName) {

        if (mapName.equals("nav")) {
            return "public/maps";
        }
        return "db-map-" + mapName;
    }
}
