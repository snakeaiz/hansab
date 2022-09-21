package it.hansab.ee.app.service;

import it.hansab.ee.app.model.Car;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CarService {

    List<Car> findAllCars();
    Car findCarById(Long id) throws Exception;
    Car save(Car car);
    Car update(Long id, Car car);
    void deleteCarById(Long id);
    Page<Car> findByNumberPlate(String numberPlateFilter, int page, int size);

}
