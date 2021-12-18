package com.mediga.comparisonapp.service;

import com.mediga.comparisonapp.exception.CarNotFoundException;
import com.mediga.comparisonapp.exception.ComparisonException;
import com.mediga.comparisonapp.model.*;
import com.mediga.comparisonapp.repository.CarRepository;
import com.mediga.comparisonapp.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ComparisonService {
    @Autowired
    private FeatureRepository featureRepository;
    @Autowired
    private RecommenderService recommenderService;
    @Autowired
    private CarRepository carRepository;

    public ComparisonResponse compareCars(ComparisonRequest comparisonRequest) throws ComparisonException, CarNotFoundException {
        if(comparisonRequest.getCarIds() == null || comparisonRequest.getCarIds().size() < 2) {
            throw new ComparisonException("2 car ids required");
        }
        if(comparisonRequest.getCarIds().size() > 2) {
            throw new ComparisonException("Maximum 2 car ids allowed");
        }
        List<Integer> carIds = comparisonRequest.getCarIds();
        Car car1 = recommenderService.getCarById(carIds.get(0));
        Car car2 = recommenderService.getCarById(carIds.get(1));
        List<Feature> features = featureRepository.getFeatures();
        return compareFeatures(car1, car2, features);
    }

    private ComparisonResponse compareFeatures(Car car1, Car car2, List<Feature> features) {
        CarFeature carFeature1 = carRepository.getCarFeatureByCarId(car1.getId());
        CarFeature carFeature2 = carRepository.getCarFeatureByCarId(car2.getId());
        Map<FeatureCategory, ComparableFeatureGroup> comparableFeatureGroupMap = new HashMap<>();
        for(Feature feature : features) {
            ComparableFeature comparableFeature = new ComparableFeature(feature.getId(), feature.getFeatureName());
            String featureValue1 = carFeature1.getFeatureValueMap().get(feature.getId());
            String featureValue2 = carFeature2.getFeatureValueMap().get(feature.getId());
            if(featureValue1 == null || featureValue1 == null) {
                comparableFeature.setIsDifferent(true);
            } else if(!featureValue1.equalsIgnoreCase(featureValue2)) {
                comparableFeature.setIsDifferent(true);
            }
            Map<Integer, String> values = new HashMap<>();
            values.put(car1.getId(), featureValue1);
            values.put(car2.getId(), featureValue2);
            comparableFeature.setValues(values);
            ComparableFeatureGroup comparableFeatureGroup = comparableFeatureGroupMap.getOrDefault(feature.getFeatureCategory(), new ComparableFeatureGroup());
            comparableFeatureGroup.setFeatureCategory(feature.getFeatureCategory());
            comparableFeatureGroup.getFeatureList().add(comparableFeature);
            comparableFeatureGroupMap.put(feature.getFeatureCategory(), comparableFeatureGroup);
        }

        List<ComparableFeatureGroup> comparableFeatureGroupList = comparableFeatureGroupMap.entrySet().stream()
                .map(e -> e.getValue()).collect(Collectors.toList());

        Map<Integer, String> carsDetails = new HashMap<>();
        carsDetails.put(car1.getId(), car1.getName());
        carsDetails.put(car2.getId(), car2.getName());
        ComparisonResponse comparisonResponse = new ComparisonResponse(carsDetails, comparableFeatureGroupList);

        return comparisonResponse;
    }
}
