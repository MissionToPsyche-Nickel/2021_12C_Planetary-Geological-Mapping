package planetarymapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import planetarymapping.Repository.Map_Repository;
import planetarymapping.model.Map;

import java.util.List;

@Controller
public class Map_Controller {

    @Autowired
    Map_Repository mapRepo;

    @GetMapping("/map")
    public String mapNav(Model model){
        List<Map> maps = mapRepo.findAll();
        model.addAttribute("maps", maps);
        return "public/maps-listing";
    }

    @GetMapping("/map/{id}")
    public String map(@PathVariable int id, Model model) {

        Map map = mapRepo.findAllById(id);
        model.addAttribute("map", map);
        return "public/map";
    }
}
