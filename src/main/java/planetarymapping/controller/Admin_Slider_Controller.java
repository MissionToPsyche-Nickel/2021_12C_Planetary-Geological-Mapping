package planetarymapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import planetarymapping.Repository.Slide_Repository;
import planetarymapping.Service.FileService;
import planetarymapping.model.Slide;

import java.util.List;

@Controller
@RequestMapping("/admin/slider")
public class Admin_Slider_Controller {

    @Autowired
    Slide_Repository slideRepo;

    @Autowired
    FileService fileService;

    /*Slider Admin*/
    @GetMapping("")
    public String slider(Model model){
        List<Slide> slides = slideRepo.findAll();
        model.addAttribute("slides", slides);
        return "admin/slider/admin-slider";
    }

    @GetMapping("/add")
    public String sliderAdd(){
        return "admin/slider/admin-slider-add";
    }

    @PostMapping("/add")
    public String sliderAdded(Model model, @RequestParam("title") String title,
                              @RequestParam("caption") String caption, @RequestParam("file") MultipartFile file){

        fileService.uploadFile(file);

        Slide slide = new Slide(title, caption, file.getOriginalFilename());
        slideRepo.save(slide);

        List<Slide> slides = slideRepo.findAll();
        model.addAttribute("slides", slides);
        return "admin/slider/admin-slider";
    }

    @GetMapping("/edit/{id}")
    public String sliderEdit(@PathVariable int id, Model model){

        Slide slide = slideRepo.findAllById(id);
        model.addAttribute("slide", slide);
        return "admin/slider/admin-slider-edit";
    }

    @PostMapping("/edit/{id}")
    public String sliderEdited(Model model, @PathVariable int id, @RequestParam("title") String title,
                              @RequestParam("caption") String caption,  @RequestParam("file") MultipartFile file){

        fileService.uploadFile(file);

        Slide slide = slideRepo.findAllById(id);

        slide.setTitle(title);
        slide.setImage(file.getOriginalFilename());
        slide.setCaption(caption);

        slideRepo.save(slide);

        List<Slide> slides = slideRepo.findAll();
        model.addAttribute("slides", slides);
        return "admin/slider/admin-slider";
    }

    @GetMapping("/delete/{id}")
    public String sliderDelete(@PathVariable int id, Model model){

        Slide slide = slideRepo.findAllById(id);
        model.addAttribute("slide", slide);
        return "admin/slider/admin-slider-delete";
    }

    @PostMapping("/delete/{id}")
    public String sliderDeleted(Model model,@PathVariable int id){

        slideRepo.deleteById(id);

        List<Slide> slides = slideRepo.findAll();
        model.addAttribute("slides", slides);
        return "admin/slider/admin-slider";
    }
}
