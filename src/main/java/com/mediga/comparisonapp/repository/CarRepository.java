package com.mediga.comparisonapp.repository;

import com.mediga.comparisonapp.model.Car;
import com.mediga.comparisonapp.model.CarFeature;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class CarRepository {
    private Map<Integer, Car> idToCarMap;
    private Map<String, List<Car>> typeToCarMap;
    private Map<Integer, CarFeature> carIdToCarFeatureMap;

    public CarRepository() {
        this.idToCarMap = new HashMap<>();
        this.typeToCarMap = new HashMap<>();
        this.carIdToCarFeatureMap = new HashMap<>();
        initialize();
    }

    private void initialize() {
        try {
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("data.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            //Skip Headers
            String line = reader.readLine();
            int id = 1;
            while((line = reader.readLine()) != null) {
                String data[] = line.split(",");
                if(data.length >= 6) {
                    String name = data[0];
                    Map<Integer, String> featureValueMap = new HashMap<>();

                    for(int i = 1; i < 6; i++) {
                        featureValueMap.put(i, data[i]);
                    }

                    Car car = new Car(id, name, data[5]);
                    idToCarMap.put(car.getId(), car);
                    List<Car> cars = typeToCarMap.getOrDefault(car.getType(), new ArrayList<>());
                    cars.add(car);
                    typeToCarMap.put(car.getType(), cars);
                    CarFeature carFeature = new CarFeature(car.getId(), featureValueMap);
                    carIdToCarFeatureMap.put(car.getId(), carFeature);
                    id++;
                }
            }
        } catch (Exception e) {
            System.out.println("Couldn't initialize data" + e);
        }
    }

    public Car getCarById(Integer id) {
        return idToCarMap.get(id);
    }

    public List<Car> getRecommendations(Car car) {
        List<Car> cars = typeToCarMap.get(car.getType());
        if(cars == null) {
            return getDefaultRecommendations();
        }
        Random random = new Random();
        int recommendationSize = 10;
        if(cars.size() < 10) {
            recommendationSize = cars.size();
        }
        cars = random.ints(recommendationSize, 0, cars.size())
                .mapToObj(cars::get)
                .collect(Collectors.toList());
        return cars;
    }

    public CarFeature getCarFeatureByCarId(Integer carId) {
        return carIdToCarFeatureMap.get(carId);
    }

    private List<Car> getDefaultRecommendations() {
        List<Car> recommendations = new ArrayList<>();
        for(Map.Entry<Integer, Car> e : idToCarMap.entrySet()) {
            recommendations.add(e.getValue());
            if(recommendations.size() == 10) {
                break;
            }
        }
        return recommendations;
    }
}
