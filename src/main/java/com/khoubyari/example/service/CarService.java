package com.khoubyari.example.service;

import com.khoubyari.example.domain.Car;
import com.khoubyari.example.dao.jpa.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/*
 * Sample service to demonstrate what the API controller would use to get things done
 */
@Service
public class CarService {

    private static final Logger log = LoggerFactory.getLogger(CarService.class);

    @Autowired
    private CarRepository carRepository;

    @Autowired
    CounterService counterService;

    @Autowired
    GaugeService gaugeService;

    public CarService() {
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public Car getCar(String id) {
        return carRepository.findOne(id);
    }

    public void updateCar(Car car) {
        carRepository.save(car);
    }

    public void deleteCar(String id) {
        carRepository.delete(id);
    }

    public Page<Car> getAllCars(Integer page, Integer size) {
        Page pageOfCars = carRepository.findAll(new PageRequest(page, size));
        // example of adding to the /metrics
        if (size > 50) {
            counterService.increment("Khoubyari.CarService.getAll.largePayload");
        }
        return pageOfCars;
    }
}
