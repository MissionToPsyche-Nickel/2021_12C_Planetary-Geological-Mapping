package planetarymapping.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GeoMappingController {

    @GetMapping("/geologic-mapping")
    public String geoMapping(){
        return "public/geologic-mapping";
    }
}
