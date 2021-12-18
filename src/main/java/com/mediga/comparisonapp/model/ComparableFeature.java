package com.mediga.comparisonapp.model;

import java.util.Map;

public class ComparableFeature {
    private Integer id;
    private String featureName;
    private boolean isDifferent;
    private Map<Integer, String> values;

    public ComparableFeature() {
    }

    public ComparableFeature(Integer id, String featureName) {
        this.id = id;
        this.featureName = featureName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public boolean getIsDifferent() {
        return isDifferent;
    }

    public void setIsDifferent(boolean isDifferent) {
        this.isDifferent = isDifferent;
    }

    public Map<Integer, String> getValues() {
        return values;
    }

    public void setValues(Map<Integer, String> values) {
        this.values = values;
    }
}
