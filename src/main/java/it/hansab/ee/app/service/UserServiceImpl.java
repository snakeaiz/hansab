package it.hansab.ee.app.service;

import it.hansab.ee.app.model.User;
import it.hansab.ee.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) throws Exception {
        return userRepository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public User save(User user){
        return userRepository.save(user);
    }

    @Override
    public User delete(Long id){
        userRepository.deleteById(id);
        return null;
    }

    @Override
    @Transactional
    public User update(Long id, User user){
        User currentUser = userRepository.findById(id).get();
        currentUser.setId(user.getId());
        currentUser.setName(user.getName());
        return userRepository.save(currentUser);
    }

}
