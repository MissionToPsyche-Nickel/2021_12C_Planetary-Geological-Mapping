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
@RequestMapping("/admin/map")
public class Admin_Map_Controller {

    @Autowired
    Map3d_Repository map3dRepo;

    @Autowired
    Map2d_Repository map2dRepo;

    /*Map Admin*/
    @GetMapping("")
    public String map(Model model){
        List<Map3d> maps3d = map3dRepo.findAll();
        List<Map2d> maps2d = map2dRepo.findAll();
        model.addAttribute("maps3d", maps3d);
        model.addAttribute("maps2d", maps2d);
        return "admin/map/admin-map";
    }

    @GetMapping("/add3d")
    public String map3dAdd(){
        return "admin/map/admin-map-add";
    }

    @GetMapping("/add2d")
    public String map2dAdd(){
        return "admin/map/admin-map-add";
    }

    @PostMapping("/add3d")
    public String map3dAdded(Model model, @RequestParam("title") String title,
                           @RequestParam("link") String link, @RequestParam("facts") String facts,
                           @RequestParam("slider_name") String slider_name, @RequestParam("image") String image){

        Map3d map3d = new Map3d(title, link, facts, slider_name, image);
        map3dRepo.save(map3d);

        List<Map3d> maps3d = map3dRepo.findAll();
        List<Map2d> maps2d = map2dRepo.findAll();
        model.addAttribute("maps3d", maps3d);
        model.addAttribute("maps2d", maps2d);
        return "admin/map/admin-map";
    }

    @PostMapping("/add2d")
    public String map2dAdded(Model model, @RequestParam("title") String title,
                           @RequestParam("link") String link, @RequestParam("facts") String facts,
                           @RequestParam("slider_name") String slider_name, @RequestParam("image") String image){

        Map2d map2d = new Map2d(title, link, facts, slider_name, image);
        map2dRepo.save(map2d);

        List<Map3d> maps3d = map3dRepo.findAll();
        List<Map2d> maps2d = map2dRepo.findAll();
        model.addAttribute("maps3d", maps3d);
        model.addAttribute("maps2d", maps2d);
        return "admin/map/admin-map";
    }

    @GetMapping("/edit3d/{id}")
    public String map3dEdit(@PathVariable int id, Model model){

        Map3d map = map3dRepo.findAllById(id);

        model.addAttribute("map", map);
        return "admin/map/admin-map-edit";
    }

    @GetMapping("/edit2d/{id}")
    public String map2dEdit(@PathVariable int id, Model model){

        Map2d map = map2dRepo.findAllById(id);

        model.addAttribute("map", map);
        return "admin/map/admin-map-edit";
    }

    @PostMapping("/edit3d/{id}")
    public String map3dEdited(Model model, @PathVariable int id, @RequestParam("title") String title,
                            @RequestParam("link") String link, @RequestParam("facts") String facts,
                            @RequestParam("sliderName") String slider_name, @RequestParam("image") String image){

        Map3d map = map3dRepo.findAllById(id);

        map.setTitle(title);
        map.setLink(link);
        map.setFacts(facts);
        map.setSliderName(slider_name);
        map.setImage(image);

        map3dRepo.save(map);

        List<Map3d> maps3d = map3dRepo.findAll();
        List<Map2d> maps2d = map2dRepo.findAll();
        model.addAttribute("maps3d", maps3d);
        model.addAttribute("maps2d", maps2d);
        return "admin/map/admin-map";
    }

    @PostMapping("/edit2d/{id}")
    public String map2dEdited(Model model, @PathVariable int id, @RequestParam("title") String title,
                            @RequestParam("link") String link, @RequestParam("facts") String facts,
                            @RequestParam("sliderName") String slider_name, @RequestParam("image") String image){

        Map2d map = map2dRepo.findAllById(id);

        map.setTitle(title);
        map.setLink(link);
        map.setFacts(facts);
        map.setSliderName(slider_name);
        map.setImage(image);

        map2dRepo.save(map);

        List<Map3d> maps3d = map3dRepo.findAll();
        List<Map2d> maps2d = map2dRepo.findAll();
        model.addAttribute("maps3d", maps3d);
        model.addAttribute("maps2d", maps2d);
        return "admin/map/admin-map";
    }

    @GetMapping("/delete3d/{id}")
    public String map3dDelete(@PathVariable int id, Model model){

        Map3d map = map3dRepo.findAllById(id);
        model.addAttribute("map", map);
        return "admin/map/admin-map-delete";
    }

    @GetMapping("/delete2d/{id}")
    public String map2dDelete(@PathVariable int id, Model model){

        Map2d map = map2dRepo.findAllById(id);
        model.addAttribute("map", map);
        return "admin/map/admin-map-delete";
    }

    @PostMapping("/delete3d/{id}")
    public String map3dDeleted(Model model,@PathVariable int id){

        map3dRepo.deleteById(id);

        List<Map3d> maps3d = map3dRepo.findAll();
        model.addAttribute("maps3d", maps3d);
        return "admin/map/admin-map";
    }

    @PostMapping("/delete2d/{id}")
    public String map2dDeleted(Model model,@PathVariable int id){

        map2dRepo.deleteById(id);

        List<Map3d> maps3d = map3dRepo.findAll();
        List<Map2d> maps2d = map2dRepo.findAll();
        model.addAttribute("maps3d", maps3d);
        model.addAttribute("maps2d", maps2d);
        return "admin/map/admin-map";
    }
}
