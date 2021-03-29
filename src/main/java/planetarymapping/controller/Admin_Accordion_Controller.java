package planetarymapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import planetarymapping.Repository.AccordionRepository;
import planetarymapping.model.Accordion;

import java.util.List;

@Controller
@RequestMapping("/admin/accordion")
public class Admin_Accordion_Controller {

    @Autowired
    AccordionRepository accordionRepo;

    /*Accordion Admin*/
    @GetMapping("")
    public String accordion(Model model){
        List<Accordion> accordions = accordionRepo.findAll();
        model.addAttribute("accordions", accordions);
        return "admin/accordion/admin-accordion";
    }

    @GetMapping("/add")
    public String accordionAdd(){
        return "admin/accordion/admin-accordion-add";
    }

    @PostMapping("/add")
    public String accordionAdded(Model model, @RequestParam("title") String title,
                                 @RequestParam("paragraph") String paragraph){

        Accordion accordion = new Accordion(title, paragraph);
        accordionRepo.save(accordion);

        List<Accordion> accordions = accordionRepo.findAll();
        model.addAttribute("accordions", accordions);
        return "admin/accordion/admin-accordion";
    }

    @GetMapping("/edit/{id}")
    public String accordionEdit(@PathVariable int id, Model model){

        Accordion accordion = accordionRepo.findAllById(id);
        accordionRepo.deleteById(id);
        model.addAttribute("accordion", accordion);
        return "admin/accordion/admin-accordion-edit";
    }

    @PostMapping("/edit/{id}")
    public String accordionEdited(Model model, @RequestParam("title") String title,
                                  @RequestParam("paragraph") String paragraph){

        Accordion accordion = new Accordion(title, paragraph);
        accordionRepo.save(accordion);

        List<Accordion> accordions = accordionRepo.findAll();
        model.addAttribute("accordions", accordions);
        return "admin/accordion/admin-accordion";
    }

    @GetMapping("/delete/{id}")
    public String accordionDelete(@PathVariable int id, Model model){

        Accordion accordion = accordionRepo.findAllById(id);
        model.addAttribute("accordion", accordion);
        return "admin/accordion/admin-accordion-delete";
    }

    @PostMapping("/delete/{id}")
    public String accordionDeleted(Model model,@PathVariable int id){

        accordionRepo.deleteById(id);

        List<Accordion> accordions = accordionRepo.findAll();
        model.addAttribute("accordions", accordions);
        return "admin/accordion/admin-accordion";
    }
}
