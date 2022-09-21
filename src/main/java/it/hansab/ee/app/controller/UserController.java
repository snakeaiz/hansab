package it.hansab.ee.app.controller;

import it.hansab.ee.app.model.User;
import it.hansab.ee.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/filteredUsers")
    public Page<User> getUsersAsDataList(@RequestParam(defaultValue = "") String firstNameFilter,
                                         @RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "30") int size){
        return userService.findByName(firstNameFilter, page, size);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) throws Exception {
        return userService.findUserById(id);
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody User user) throws Exception {
        userService.save(user);
    }

    @DeleteMapping("/users/{id}")
    public User deleteUserById(@PathVariable Long id){
        return userService.delete(id);
    }

    @PutMapping(value = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateUserById(@PathVariable Long id, @RequestBody User user){
        return userService.update(id, user);
    }

}
