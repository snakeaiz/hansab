package it.hansab.ee.app.controller;

import it.hansab.ee.app.model.Car;
import it.hansab.ee.app.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/cars")
    public List<Car> getAllCars(){
        return carService.getCars();
    }

    @GetMapping("/cars/{id}")
    public Car getCarById(@PathVariable Long id){
        return carService.getCarById(id).get();
    }

    @PostMapping(value = "/cars", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Car> createUser(@RequestBody Car car) throws Exception {
        Car c = carService.save(car);
        if (c == null){
            throw new Exception();
        } else {
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        }
    }

    @PutMapping("/cars/{id}")
    public Car updateCarById(@PathVariable Long id, @RequestBody Car car){
        return carService.update(id, car);
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCarById(@PathVariable Long id){
        carService.deleteCarById(id);
    }
}
