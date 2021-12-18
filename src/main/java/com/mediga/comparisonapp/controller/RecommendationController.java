package com.mediga.comparisonapp.controller;

import com.mediga.comparisonapp.exception.CarNotFoundException;
import com.mediga.comparisonapp.model.Car;
import com.mediga.comparisonapp.service.RecommenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecommendationController {
    @Autowired
    private RecommenderService recommenderService;

   /* @GetMapping("/car/{name}")
    public ResponseEntity<Car> getCarByName(@PathVariable String name) throws CarNotFoundException {
        Car car = recommenderService.getCarByName(name);
        ResponseEntity<Car> responseEntity = new ResponseEntity<>(car, HttpStatus.OK);
       return responseEntity;
    }*/

    @GetMapping("/car/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Integer id) throws CarNotFoundException {
        Car car = recommenderService.getCarById(id);
        ResponseEntity<Car> responseEntity = new ResponseEntity<>(car, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/car/recommendations/{carId}")
    public ResponseEntity<List<Car>> getRecommendations(@PathVariable Integer carId) throws CarNotFoundException {
        List<Car> recommendations = recommenderService.getRecommendations(carId);
        ResponseEntity<List<Car>> responseEntity = new ResponseEntity<>(recommendations, HttpStatus.OK);
        return responseEntity;
    }
}
