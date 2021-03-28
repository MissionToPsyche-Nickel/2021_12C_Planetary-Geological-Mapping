package planetarymapping.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import planetarymapping.Repository.MapRepository;
import planetarymapping.Repository.SlideRepository;
import planetarymapping.model.Map;
import planetarymapping.model.Slide;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    SlideRepository slideRepo;

    @Autowired
    MapRepository mapRepo;

    @GetMapping("")
    public String admin(){
        return "admin/admin-home";
    }

    /*Slider Admin*/
    @GetMapping("/slider")
    public String slider(Model model){
        List<Slide> slides = slideRepo.findAll();
        model.addAttribute("slides", slides);
        return "admin/slider/admin-slider";
    }

    @GetMapping("/slider/add")
    public String sliderAdd(){
        return "admin/slider/admin-slider-add";
    }

    @PostMapping("/slider/add")
    public String sliderAdded(Model model, @RequestParam("title") String title,
                              @RequestParam("caption") String caption, @RequestParam("image") String image){

        Slide slide = new Slide(title, caption, image);
        slideRepo.save(slide);

        List<Slide> slides = slideRepo.findAll();
        model.addAttribute("slides", slides);
        return "admin/slider/admin-slider";
    }

    @GetMapping("/slider/edit/{id}")
    public String sliderEdit(@PathVariable int id, Model model){

        Slide slide = slideRepo.findAllById(id);
        slideRepo.deleteById(id);
        model.addAttribute("slide", slide);
        return "admin/slider/admin-slider-edit";
    }

    @PostMapping("/slider/edit/{id}")
    public String sliderEdited(Model model,@PathVariable int id, @RequestParam("title") String title,
                              @RequestParam("caption") String caption, @RequestParam("image") String image){

        Slide slide = new Slide(id, title, caption, image);

        slideRepo.save(slide);

        List<Slide> slides = slideRepo.findAll();
        model.addAttribute("slides", slides);
        return "admin/slider/admin-slider";
    }

    @GetMapping("/slider/delete/{id}")
    public String sliderDelete(@PathVariable int id, Model model){

        Slide slide = slideRepo.findAllById(id);
        model.addAttribute("slide", slide);
        return "admin/slider/admin-slider-delete";
    }

    @PostMapping("/slider/delete/{id}")
    public String sliderDeleted(Model model,@PathVariable int id){

        slideRepo.deleteById(id);

        List<Slide> slides = slideRepo.findAll();
        model.addAttribute("slides", slides);
        return "admin/slider/admin-slider";
    }

    /*Map Admin*/
    @GetMapping("/map")
    public String map(Model model){
        List<Map> maps = mapRepo.findAll();
        model.addAttribute("maps", maps);
        return "admin/map/admin-map";
    }

    @GetMapping("/map/add")
    public String mapAdd(){
        return "admin/map/admin-map-add";
    }

    @PostMapping("/map/add")
    public String mapAdded(Model model, @RequestParam("title") String title,
                              @RequestParam("link") String link, @RequestParam("facts") String facts,
                           @RequestParam("slider_name") String slider_name, @RequestParam("image") String image){

        Map map = new Map(title, link, facts, slider_name, image);
        mapRepo.save(map);

        List<Map> maps = mapRepo.findAll();
        model.addAttribute("maps", maps);
        return "admin/map/admin-map";
    }

    @GetMapping("/map/edit/{id}")
    public String mapEdit(@PathVariable int id, Model model){

        Map map = mapRepo.findAllById(id);
        mapRepo.deleteById(id);
        model.addAttribute("map", map);
        return "admin/map/admin-map-edit";
    }

    @PostMapping("/map/edit/{id}")
    public String mapEdited(Model model, @PathVariable int id, @RequestParam("title") String title,
                            @RequestParam("link") String link, @RequestParam("facts") String facts,
                            @RequestParam("sliderName") String slider_name, @RequestParam("image") String image){

        Map map = new Map(id, title, link, facts, slider_name, image);
        mapRepo.save(map);

        List<Map> maps = mapRepo.findAll();
        model.addAttribute("maps", maps);
        return "admin/map/admin-map";
    }

    @GetMapping("/map/delete/{id}")
    public String mapDelete(@PathVariable int id, Model model){

        Map map = mapRepo.findAllById(id);
        model.addAttribute("map", map);
        return "admin/map/admin-map-delete";
    }

    @PostMapping("/map/delete/{id}")
    public String mapDeleted(Model model,@PathVariable int id){

        mapRepo.deleteById(id);

        List<Map> maps = mapRepo.findAll();
        model.addAttribute("maps", maps);
        return "admin/map/admin-map";
    }
}
