package com.mediga.comparisonapp.model;

import java.util.Map;

public class CarFeature {
    private Integer carId;
    private Map<Integer, String> featureValueMap;

    public CarFeature() {
    }

    public CarFeature(Integer carId, Map<Integer, String> featureValueMap) {
        this.carId = carId;
        this.featureValueMap = featureValueMap;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Map<Integer, String> getFeatureValueMap() {
        return featureValueMap;
    }

    public void setFeatureValueMap(Map<Integer, String> featureValueMap) {
        this.featureValueMap = featureValueMap;
    }
}
