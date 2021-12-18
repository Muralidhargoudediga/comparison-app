package com.mediga.comparisonapp.service;

import com.mediga.comparisonapp.exception.CarNotFoundException;
import com.mediga.comparisonapp.model.Car;
import com.mediga.comparisonapp.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommenderService {
    @Autowired
    private CarRepository carRepository;

    public Car getCarById(Integer id) throws CarNotFoundException {
        if(id == null) {
            throw new CarNotFoundException("name cannot be null/empty");
        }
        Car car = carRepository.getCarById(id);
        if(car == null) {
            throw new CarNotFoundException("Not found any car with id " + id);
        }
        return car;
    }

    public List<Car> getRecommendations(Integer carId) throws CarNotFoundException {
        Car car = getCarById(carId);
        return carRepository.getRecommendations(car);
    }
}
