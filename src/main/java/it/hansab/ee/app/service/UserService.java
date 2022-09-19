package it.hansab.ee.app.service;

import it.hansab.ee.app.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService{

    List<User> findAllUsers();
    User findUserById(Long id) throws Exception;
    User save(User user);
    User delete(Long id);
    User update(Long id, User user);

}
