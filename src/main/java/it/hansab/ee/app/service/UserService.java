package it.hansab.ee.app.service;

import it.hansab.ee.app.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService{

    List<User> findAllUsers();
    User findUserById(Long id) throws Exception;
    void save(User user);
    User delete(Long id);
    User update(Long id, User user);
    Page<User> findByName(String nameFilter, int page, int size);

}
