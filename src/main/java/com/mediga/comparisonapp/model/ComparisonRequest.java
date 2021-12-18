package com.mediga.comparisonapp.model;

import java.util.List;

public class ComparisonRequest {
    private List<Integer> carIds;

    public List<Integer> getCarIds() {
        return carIds;
    }

    public void setCarIds(List<Integer> carIds) {
        this.carIds = carIds;
    }
}
