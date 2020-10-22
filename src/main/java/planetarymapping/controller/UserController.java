package planetarymapping.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import planetarymapping.Assembler.UserModelAssembler;
import planetarymapping.Exception.UserNotFoundException;
import planetarymapping.Repository.UserRepository;
import planetarymapping.model.User;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
//@RequestMapping("/user")
public class UserController {

        private final UserRepository repository;       //User repository decleration
        private final UserModelAssembler assembler;     //User assembler decleration, used for RESTfulness

        UserController(UserRepository repository, UserModelAssembler assembler) {
                this.repository = repository;
                this.assembler = assembler;
        }

        //GET Request listing a specific user
        @GetMapping("/list/{id}")
        public EntityModel<User> one(@PathVariable Long id){
                User u = repository.findById(id)
                         .orElseThrow(() -> new UserNotFoundException(id));
               return assembler.toModel(u);
        }

        //GET Request to list all the users
        @RequestMapping("/list")
        public CollectionModel<EntityModel<User>> all(){
                List<EntityModel<User>> us = repository.findAll().stream() //
                        .map(assembler::toModel) //
                        .collect(Collectors.toList());

                return CollectionModel.of(us, linkTo(methodOn(UserController.class).all()).withSelfRel());
        }

        //Post to add a user to the database
        @PostMapping("/add")
        public String addUser(@RequestParam String userName, String password, boolean enabled){
                User u = new User(userName);
                repository.save(u);
                return String.format("User %s added!", userName);
        }
}
