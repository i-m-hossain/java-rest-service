package com.restwebservice.RestWebService.User;

import com.restwebservice.RestWebService.Post.Post;
import com.restwebservice.RestWebService.Post.PostRepository;
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
@RestController()
public class UserJpaResource {
    private UserRepo repository;
    private PostRepository postRepository;
    UserJpaResource(UserRepo userRepo, PostRepository postRepository){
        this.repository = userRepo;
        this.postRepository= postRepository;
    }
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return repository.findAll();
    }
    @PostMapping("/jpa/users")
    public ResponseEntity<Object> storeUser(@Valid @RequestBody User user){
        User savedUser = repository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> getUserById(@PathVariable int id){
       Optional<User> user =  repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id"+id);
        }
        EntityModel<User> entityModel=EntityModel.of(user.get());
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }
    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> savePostOfUser(@Valid @RequestBody Post post, @PathVariable Integer id){
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("user id not found");
        }
        post.setUser(user.get());
        Post savedPost =postRepository.save(post);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> getAllPostOfUser(@PathVariable int id){
        Optional<User> user = repository.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("user not found");
        return user.get().getPosts();
    }
    @DeleteMapping("/jpa/users/{id}")
    public void removeUser(@PathVariable int id){
        repository.deleteById(id);
    }

}
