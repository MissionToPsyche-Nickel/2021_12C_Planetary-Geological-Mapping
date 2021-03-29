package planetarymapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import planetarymapping.Repository.MapRepository;
import planetarymapping.model.Map;

import java.util.List;

@Controller
@RequestMapping("/admin/map")
public class Admin_Map_Controller {

    @Autowired
    MapRepository mapRepo;

    /*Map Admin*/
    @GetMapping("")
    public String map(Model model){
        List<Map> maps = mapRepo.findAll();
        model.addAttribute("maps", maps);
        return "admin/map/admin-map";
    }

    @GetMapping("/add")
    public String mapAdd(){
        return "admin/map/admin-map-add";
    }

    @PostMapping("/add")
    public String mapAdded(Model model, @RequestParam("title") String title,
                           @RequestParam("link") String link, @RequestParam("facts") String facts,
                           @RequestParam("slider_name") String slider_name, @RequestParam("image") String image){

        Map map = new Map(title, link, facts, slider_name, image);
        mapRepo.save(map);

        List<Map> maps = mapRepo.findAll();
        model.addAttribute("maps", maps);
        return "admin/map/admin-map";
    }

    @GetMapping("/edit/{id}")
    public String mapEdit(@PathVariable int id, Model model){

        Map map = mapRepo.findAllById(id);
        mapRepo.deleteById(id);
        model.addAttribute("map", map);
        return "admin/map/admin-map-edit";
    }

    @PostMapping("/edit/{id}")
    public String mapEdited(Model model, @PathVariable int id, @RequestParam("title") String title,
                            @RequestParam("link") String link, @RequestParam("facts") String facts,
                            @RequestParam("sliderName") String slider_name, @RequestParam("image") String image){

        Map map = new Map(title, link, facts, slider_name, image);
        mapRepo.save(map);

        List<Map> maps = mapRepo.findAll();
        model.addAttribute("maps", maps);
        return "admin/map/admin-map";
    }

    @GetMapping("/delete/{id}")
    public String mapDelete(@PathVariable int id, Model model){

        Map map = mapRepo.findAllById(id);
        model.addAttribute("map", map);
        return "admin/map/admin-map-delete";
    }

    @PostMapping("/delete/{id}")
    public String mapDeleted(Model model,@PathVariable int id){

        mapRepo.deleteById(id);

        List<Map> maps = mapRepo.findAll();
        model.addAttribute("maps", maps);
        return "admin/map/admin-map";
    }
}
