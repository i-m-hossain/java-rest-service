package com.restwebservice.RestWebService.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController()
public class UserResource {
    private final UserDaoService service;
    public UserResource(UserDaoService service){
        this.service = service;
    }
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }
    @PostMapping("/users")
    public ResponseEntity<Object> storeUser(@RequestBody User user){
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id){
        return service.findOne(id);
    }
    @PutMapping("/users/{id}")
    public User updateUserById(@PathVariable int id, @RequestBody User user){
        return service.updateOne(id, user);
    }
}
