package it.hansab.ee.app.service;

import it.hansab.ee.app.model.User;
import it.hansab.ee.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public void save(User user){
        userRepository.save(user);
    }

    @Override
    public User delete(Long id){
        userRepository.deleteById(id);
        return null;
    }

    @Override
    public Page<User> findByName(String name, int page, int size){
        PageRequest pageable = PageRequest.of(page, size);
        return userRepository.findByName(name, (org.springframework.data.domain.Pageable) pageable);
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
