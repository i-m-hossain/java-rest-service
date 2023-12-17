package com.restwebservice.RestWebService.Post;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostResource {
    private final PostRepository repository;
    private PostResource(PostRepository postRepository){
        this.repository= postRepository;
    }
    @GetMapping("/posts")
    public List<Post> retrievePosts(){
        return repository.findAll();
    }



}
