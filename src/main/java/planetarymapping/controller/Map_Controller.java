package planetarymapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import planetarymapping.Repository.Map2d_Repository;
import planetarymapping.Repository.Map3d_Repository;
import planetarymapping.model.Map2d;
import planetarymapping.model.Map3d;

import java.util.List;

@Controller
public class Map_Controller {

    @Autowired
    Map3d_Repository map3dRepo;

    @Autowired
    Map2d_Repository map2dRepo;

    @GetMapping("/map")
    public String mapNav(Model model){
        List<Map3d> maps3D = map3dRepo.findAll();
        List<Map2d> maps2D = map2dRepo.findAll();
        model.addAttribute("maps3D", maps3D);
        model.addAttribute("maps2D", maps2D);
        return "public/maps-listing";
    }

    @GetMapping("/map3d/{id}")
    public String map3d(@PathVariable int id, Model model) {

        Map3d map = map3dRepo.findAllById(id);
        model.addAttribute("map", map);
        return "public/map";
    }

    @GetMapping("/map2d/{id}")
    public String map2d(@PathVariable int id, Model model) {

        Map2d map = map2dRepo.findAllById(id);
        model.addAttribute("map", map);
        return "public/map";
    }
}
