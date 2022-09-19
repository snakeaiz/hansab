package it.hansab.ee.app.service;

import it.hansab.ee.app.model.Car;
import it.hansab.ee.app.model.User;
import it.hansab.ee.app.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = UserServiceImpl.class)
class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    List<Car> carsList = new ArrayList<>();
    List<User> userList = new ArrayList<>();
    User u = new User();

    @BeforeEach
    void setUp(){

        u.setCars(carsList);
        u.setName("Aslan");
        u.setId(1L);
        userRepository.save(u);
        userList.add(u);
    }

    @DisplayName("Find All Users Test")
    @Test
    void findAllUsersTest() {
        when(userRepository.findAll())
                .thenReturn(userList);

        assertEquals(u, userService.findAllUsers().get(0));

        verify(userRepository, times(1))
                .findAll();
    }

    @Test
    void findUserByIdTest() throws Exception {
        when(userRepository.findById(u.getId()))
                .thenReturn(java.util.Optional.ofNullable(u));

        assertEquals(u, userService.findUserById(u.getId()));
        assertEquals(1L, u.getId());
        verify(userRepository, times(1)).findById(u.getId());
    }

    @Test
    void saveUserTest() throws Exception {
        when(userRepository.save(Mockito.any(User.class)))
                .thenAnswer(i -> i.getArguments()[0]);

//        assertEquals(u, userService.findAllUsers().get(0));
//        assertEquals(1L, userService.findAllUsers().get(0).getId());
//        assertEquals("Aslan", userService.findUserById(1L).getName());

        verify(userRepository, times(1)).save(u);
    }

    @Test
    void deleteUserTest() {

    }

    @Test
    void updateUserTest() {
    }
}