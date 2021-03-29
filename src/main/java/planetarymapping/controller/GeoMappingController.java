package planetarymapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import planetarymapping.Repository.AccordionRepository;
import planetarymapping.model.Accordion;


import java.util.List;

@Controller
public class GeoMappingController {

    @Autowired
    AccordionRepository accordionRepo;

    @GetMapping("/geologic-mapping")
    public String geoMapping(Model model){

        List<Accordion> accordions = accordionRepo.findAll();
        model.addAttribute("accordions", accordions);
        return "public/geologic-mapping";
    }
}
