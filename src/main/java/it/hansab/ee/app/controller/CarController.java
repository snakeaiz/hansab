package it.hansab.ee.app.controller;

import it.hansab.ee.app.model.Car;
import it.hansab.ee.app.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/cars")
    public List<Car> getAllCars(){
        return carService.findAllCars();
    }

    @GetMapping("/filteredCars")
    public Page<Car> getCarsAsFilteredDataList(@RequestParam(defaultValue = "") String numberPlateFilter,
                                         @RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "30") int size){
        return carService.findByNumberPlate(numberPlateFilter, page, size);
    }

    @GetMapping("/cars/{id}")
    public Car getCarById(@PathVariable Long id) throws Exception {
        return carService.findCarById(id);
    }

    @PostMapping(value = "/cars", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createCar(@RequestBody Car car) throws Exception {
        carService.save(car);
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
