package com.mediga.comparisonapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComparisonResponse {
    private Map<Integer, String> carsDetails;
    private List<ComparableFeatureGroup> comparableFeatureList;

    public ComparisonResponse() {
        this.carsDetails = new HashMap<>();
        this.comparableFeatureList = new ArrayList<>();
    }

    public ComparisonResponse(Map<Integer, String> carsDetails, List<ComparableFeatureGroup> comparableFeatureList) {
        this.carsDetails = carsDetails;
        this.comparableFeatureList = comparableFeatureList;
    }

    public Map<Integer, String> getCarsDetails() {
        return carsDetails;
    }

    public void setCarsDetails(Map<Integer, String> carsDetails) {
        this.carsDetails = carsDetails;
    }

    public List<ComparableFeatureGroup> getComparableFeatureList() {
        return comparableFeatureList;
    }

    public void setComparableFeatureList(List<ComparableFeatureGroup> comparableFeatureList) {
        this.comparableFeatureList = comparableFeatureList;
    }
}
