package it.hansab.ee.app.service;

import it.hansab.ee.app.model.Car;
import it.hansab.ee.app.model.User;
import it.hansab.ee.app.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = CarServiceImpl.class)
public class CarServiceTest {

    @MockBean
    private CarRepository carRepository;

    @Autowired
    private CarService carService;

    List<Car> carsList = new ArrayList<>();
    Car carActual = new Car();
    User user = new User();

    @BeforeEach
    void setUp() {

        carActual.setUser(user);
        carActual.setModel("M4");
        carActual.setNumberplate("123ABC");
        carActual.setMake("BMW");
        carActual.setId(1L);
        carRepository.save(carActual);
        carsList.add(carActual);
    }

    @DisplayName("JUnit test for retrieving all Cars")
    @Test
    void givenCarList_whenFindAll_thenCarList() {
        when(carRepository.findAll())
                .thenReturn(carsList);

        assertEquals(carActual, carService.findAllCars().get(0));

        verify(carRepository, times(1))
                .findAll();
    }

    @DisplayName("JUnit test for updating Car operation")
    @Test
    void givenCarObject_whenUpdate_thenReturnUpdatedCar() {

        when(carRepository.save(carActual)).thenReturn(carActual);

        carActual.setId(4L);
        carActual.setModel("Q8");
        carActual.setMake("Audi");

        Car updatedCar = carRepository.save(carActual);

        assertThat(updatedCar.getMake()).isEqualTo("Audi");
        assertThat(updatedCar.getModel()).isEqualTo("Q8");
        assertThat(updatedCar.getId()).isEqualTo(4L);
    }

    @DisplayName("JUnit test for delete Car operation")
    @Test
    void givenCarObject_WhenDelete_thenRemoveCar() {
        carRepository.deleteById(carActual.getId());
        Optional<Car> optionalCar = carRepository.findById(carActual.getId());

        assertThat(optionalCar).isEmpty();
    }

    @DisplayName("JUnit test for saving Car operation")
    @Test
    void givenCarObject_whenSaved_thenIsPresent() throws Exception {

        when(carRepository.save(carActual)).thenReturn(carActual);

        assertThat(carActual).isNotNull();
        assertThat(carActual.getId()).isEqualTo(1L);

        verify(carRepository, times(1)).save(carActual);
    }

    @DisplayName("JUnit test for retrieving Car by Id")
    @Test
    void givenCarObject_whenFindById_thenReturnCar() throws Exception {
        when(carRepository.findById(carActual.getId()))
                .thenReturn(java.util.Optional.ofNullable(carActual));

        assertEquals(carActual, carService.findCarById(carActual.getId()));
        assertEquals(1L, carActual.getId());
        verify(carRepository, times(1)).findById(carActual.getId());
    }

}
