package planetarymapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import planetarymapping.repository.Map2d_Repository;
import planetarymapping.repository.Map3d_Repository;
import planetarymapping.model.Map2d;
import planetarymapping.model.Map3d;

import java.util.List;

@Controller
public class Map_Controller {

    //Injecting the 3d-Map persistence object
    @Autowired
    private Map3d_Repository map3dRepo;

    //Injecting the 2d-Map persistence object
    @Autowired
    private Map2d_Repository map2dRepo;

    //Displaying the map root page
    @GetMapping("/map")
    public String mapNav(Model model){
        List<Map3d> maps3D = map3dRepo.findAll();
        List<Map2d> maps2D = map2dRepo.findAll();
        model.addAttribute("maps3D", maps3D);
        model.addAttribute("maps2D", maps2D);
        model.addAttribute("classActiveSettings","active");
        return "public/maps-listing";
    }

    //Displaying a 3d-Map
    @GetMapping("/map3d/{id}")
    public String map3d(@PathVariable int id, Model model) {

        Map3d map = map3dRepo.findAllById(id);
        model.addAttribute("map", map);
        return "public/map";
    }

    //Displaying a 2d-Map
    @GetMapping("/map2d/{id}")
    public String map2d(@PathVariable int id, Model model) {

        Map2d map = map2dRepo.findAllById(id);
        model.addAttribute("map", map);
        return "public/map";
    }
}
