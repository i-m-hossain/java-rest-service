package com.restwebservice.RestWebService.User;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static int usersCount = 0;
    private static final List<User> users = new ArrayList<>();
    static {
        users.add(new User( ++usersCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User( ++usersCount, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User( ++usersCount, "Jim", LocalDate.now().minusYears(23)));
        users.add(new User( ++usersCount, "Kim", LocalDate.now().minusYears(21)));
        users.add(new User( ++usersCount, "Vim", LocalDate.now().minusYears(24)));
    }
    public List<User> findAll(){
        return users;
    }
    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }
    public User findOne(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
    public User updateOne(int id, User user){
        return user;
    }
}
