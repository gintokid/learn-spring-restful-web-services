package com.madroid.rest.webservices.restfulwebservices.jpa;

import com.madroid.rest.webservices.restfulwebservices.user.User;
import com.madroid.rest.webservices.restfulwebservices.user.UserDaoService;
import com.madroid.rest.webservices.restfulwebservices.user.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {


    private UserDaoService service;

    private UserRepository repository;

    public UserJpaResource(UserDaoService userDaoService, UserRepository repository) {
        this.service = userDaoService;
        this.repository = repository;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveUsers() {
        return repository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        Optional<User> user = repository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException("User with id " + id + " not found");

        EntityModel<User> entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveUsers());
        entityModel.add(link.withRel("all-users"));


        return entityModel;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User saved = repository.save(user);

        //location -/users/5
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
        repository.deleteById(id);
    }
}
