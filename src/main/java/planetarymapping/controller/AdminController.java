package planetarymapping.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import planetarymapping.Repository.SlideRepository;
import planetarymapping.model.Slide;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    SlideRepository slideRepo;

    @GetMapping("")
    public String admin(){
        return "admin/admin-home";
    }

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
}
