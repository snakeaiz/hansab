package it.hansab.ee.app.service;

import it.hansab.ee.app.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> getCars();
    Optional<Car> getCarById(Long id);
    Car save(Car car);
    Car update(Long id, Car car);
    void deleteCarById(Long id);

}
