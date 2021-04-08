package planetarymapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import planetarymapping.repository.Accordion_Repository;
import planetarymapping.model.Accordion;

import java.util.List;

@Controller
@RequestMapping("/admin/accordion")
public class Admin_Accordion_Controller {

    //Injecting the accordion persistence object
    @Autowired
    Accordion_Repository accordionRepo;

    //Displaying accordion admin home
    @GetMapping("")
    public String accordion(Model model){
        List<Accordion> accordions = accordionRepo.findAll();
        model.addAttribute("accordions", accordions);
        return "admin/accordion/admin-accordion";
    }

    //Displaying the add page
    @GetMapping("/add")
    public String accordionAdd(){
        return "admin/accordion/admin-accordion-add";
    }

    //Processing adding a new accordion entry
    @PostMapping("/add")
    public String accordionAdded(Model model, @RequestParam("title") String title,
                                 @RequestParam("paragraph") String paragraph){

        Accordion accordion = new Accordion(title, paragraph);
        accordionRepo.save(accordion);

        List<Accordion> accordions = accordionRepo.findAll();
        model.addAttribute("accordions", accordions);
        return "admin/accordion/admin-accordion";
    }

    //Displaying the accordion to edit
    @GetMapping("/edit/{id}")
    public String accordionEdit(@PathVariable int id, Model model){

        Accordion accordion = accordionRepo.findAllById(id);

        model.addAttribute("accordion", accordion);
        return "admin/accordion/admin-accordion-edit";
    }

    //Processing the edited accordion
    @PostMapping("/edit/{id}")
    public String accordionEdited(Model model, @PathVariable int id, @RequestParam("title") String title,
                                  @RequestParam("paragraph") String paragraph){

        Accordion accordion = accordionRepo.findAllById(id);

        accordion.setTitle(title);
        accordion.setParagraph(paragraph);

        accordionRepo.save(accordion);

        List<Accordion> accordions = accordionRepo.findAll();
        model.addAttribute("accordions", accordions);
        return "admin/accordion/admin-accordion";
    }

    //Displaying the accordion to delete
    @GetMapping("/delete/{id}")
    public String accordionDelete(@PathVariable int id, Model model){

        Accordion accordion = accordionRepo.findAllById(id);
        model.addAttribute("accordion", accordion);
        return "admin/accordion/admin-accordion-delete";
    }

    //Processing the accordion to delete
    @PostMapping("/delete/{id}")
    public String accordionDeleted(Model model,@PathVariable int id){

        accordionRepo.deleteById(id);

        List<Accordion> accordions = accordionRepo.findAll();
        model.addAttribute("accordions", accordions);
        return "admin/accordion/admin-accordion";
    }
}
