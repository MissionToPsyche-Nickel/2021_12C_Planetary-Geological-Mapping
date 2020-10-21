package planetarymapping.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import planetarymapping.Assembler.UserModelAssembler;
import planetarymapping.Exception.UserNotFoundException;
import planetarymapping.Repository.UsersRepository;
import planetarymapping.model.User;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/user")
public class UserController {

        private final UsersRepository repository;       //User repository decleration
        private final UserModelAssembler assembler;     //User assembler decleration, used for RESTfulness

        UserController(UsersRepository repository, UserModelAssembler assembler){
                this.repository = repository;
                this.assembler = assembler;
        }

        //Temporary hello page
        @RequestMapping("/hello")
        public String hello(){
                return "Hello There!";
        }

        //Listing a specific user, uses assembler to set links
        @RequestMapping("/list/{id}")
        public EntityModel<User> one(@PathVariable Long id){
                User u = repository.findById(id)
                         .orElseThrow(() -> new UserNotFoundException(id));
               return assembler.toModel(u);
        }

        /*
        @RequestMapping("/list")
        public CollectionModel<EntityModel<User>> all(){
                List<EntityModel<User>> us = repository.findAll().stream()
                        .map(assembler::toModel) //
                        .collect(Collectors.toList());

                return CollectionModel.of(us, linkTo(methodOn(UserController.class).all()).withSelfRel());
        }*/

        //Post to add a user to the database
        @PostMapping("/add")
        public String addUser(@RequestParam String userName, String password, int type){
                User u = new User(userName, password, type);
                repository.save(u);
                return String.format("User %s added!", userName);
        }
}
