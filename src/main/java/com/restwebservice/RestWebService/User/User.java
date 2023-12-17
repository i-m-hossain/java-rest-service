package com.restwebservice.RestWebService.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.restwebservice.RestWebService.Post.Post;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity(name="user_details")
public class User {
    protected User(){

    }
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2, message = "name must be 2 or more characters")
    @JsonProperty("userName")
    private String name;

    @Past(message = "birthdate must be before today")
    @JsonProperty("birthDate")
    @Column(name = "birth_date")
    private LocalDate birthdate;

    @OneToMany(mappedBy = "user") //user field in the post model
    @JsonIgnore
    private List<Post> posts;
    public User(Integer id, String name, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
