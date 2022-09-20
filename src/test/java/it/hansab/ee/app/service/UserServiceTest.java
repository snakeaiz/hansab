package it.hansab.ee.app.service;

import it.hansab.ee.app.model.Car;
import it.hansab.ee.app.model.User;
import it.hansab.ee.app.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = UserServiceImpl.class)
class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    List<Car> carsList = new ArrayList<>();
    List<User> userList = new ArrayList<>();
    User userActual = new User();

    @BeforeEach
    void setUp(){

        userActual.setCars(carsList);
        userActual.setName("Aslan");
        userActual.setId(1L);
        userRepository.save(userActual);
        userList.add(userActual);
    }

    @DisplayName("JUnit test for retrieving all Users")
    @Test
    void givenUserList_whenFindAll_thenUserList() {
        when(userRepository.findAll())
                .thenReturn(userList);

        assertEquals(userActual, userService.findAllUsers().get(0));

        verify(userRepository, times(1))
                .findAll();
    }

    @DisplayName("JUnit test for retrieving User by Id")
    @Test
    void findUserByIdTest() throws Exception {
        when(userRepository.findById(userActual.getId()))
                .thenReturn(java.util.Optional.ofNullable(userActual));

        assertEquals(userActual, userService.findUserById(userActual.getId()));
        assertEquals(1L, userActual.getId());
        verify(userRepository, times(1)).findById(userActual.getId());
    }

    @DisplayName("JUnit test for saving User operation")
    @Test
    void givenUserObject_whenSaved_thenIsPresent() throws Exception {
        assertThat(userActual).isNotNull();
        assertThat(userActual.getId()).isEqualTo(1L);

        verify(userRepository, times(1)).save(userActual);
    }

    @DisplayName("JUnit test for delete User operation")
    @Test
    void givenUserObject_WhenDelete_thenRemoveUser() {
        userRepository.deleteById(userActual.getId());
        Optional<User> optionalUser = userRepository.findById(userActual.getId());

        assertThat(optionalUser).isEmpty();
    }

    @DisplayName("JUnit test for updating User operation")
    @Test
    void givenUserObject_whenUpdate_thenReturnUpdatedUser() {

        when(userRepository.save(userActual)).thenReturn(userActual);
        userActual.setId(4L);
        userActual.setName("Valakas");
        User updatedUser = userRepository.save(userActual);

        assertThat(updatedUser.getName()).isEqualTo("Valakas");
        assertThat(updatedUser.getId()).isEqualTo(4L);
    }
}