package it.hansab.ee.app.service;

import it.hansab.ee.app.model.Car;
import it.hansab.ee.app.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> getCars(){
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> getCarById(Long id){
        return carRepository.findById(id);
    }

    @Override
    public Car save(Car car){
        return carRepository.save(car);
    }

    @Override
    public Car update(Long id,Car car){
        Optional<Car> currentCar = carRepository.findById(id);
        Car newCar = new Car();
        newCar.setId(currentCar.get().getId());
        newCar.setMake(car.getMake());
        newCar.setModel(car.getModel());
        newCar.setNumberplate(car.getNumberplate());
        newCar.setUser(car.getUser());
        return carRepository.save(newCar);
    }

    @Override
    public void deleteCarById(Long id){
         carRepository.deleteById(id);
    }
}
