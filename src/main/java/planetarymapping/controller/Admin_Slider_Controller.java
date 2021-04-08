package planetarymapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import planetarymapping.repository.Slide_Repository;
import planetarymapping.service.FileService;
import planetarymapping.model.Slide;

import java.util.List;

@Controller
@RequestMapping("/admin/slider")
public class Admin_Slider_Controller {

    //Injecting the Slide persistence object
    @Autowired
    Slide_Repository slideRepo;

    //Injecting the service used for file uploads
    @Autowired
    FileService fileService;

    //Displaying the root silde admin page
    @GetMapping("")
    public String slider(Model model){
        List<Slide> slides = slideRepo.findAll();
        model.addAttribute("slides", slides);
        return "admin/slider/admin-slider";
    }

    //Displaying the add new slide page
    @GetMapping("/add")
    public String sliderAdd(){
        return "admin/slider/admin-slider-add";
    }

    //Processing the new slide
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

    //Displaying the slide to edit
    @GetMapping("/edit/{id}")
    public String sliderEdit(@PathVariable int id, Model model){

        Slide slide = slideRepo.findAllById(id);
        model.addAttribute("slide", slide);
        return "admin/slider/admin-slider-edit";
    }

    //Processing the edited slide
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

    //Displaying the slide to delete
    @GetMapping("/delete/{id}")
    public String sliderDelete(@PathVariable int id, Model model){

        Slide slide = slideRepo.findAllById(id);
        model.addAttribute("slide", slide);
        return "admin/slider/admin-slider-delete";
    }

    //Processing the slide to delete
    @PostMapping("/delete/{id}")
    public String sliderDeleted(Model model,@PathVariable int id){

        slideRepo.deleteById(id);

        List<Slide> slides = slideRepo.findAll();
        model.addAttribute("slides", slides);
        return "admin/slider/admin-slider";
    }
}
