package it.hansab.ee.app.controller;

import it.hansab.ee.app.model.User;
import it.hansab.ee.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getAllCars(){
        return userService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getCarById(@PathVariable Long id) throws Exception {
        return userService.findUserById(id);
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user) throws Exception {
        User u = userService.save(user);
        if (u == null){
            throw new Exception();
        } else {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/users/{id}")
    public User deleteById(@PathVariable Long id){
        return userService.delete(id);
    }

    @PutMapping(value = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateById(@PathVariable Long id, @RequestBody User user){
        return userService.update(id, user);
    }

}