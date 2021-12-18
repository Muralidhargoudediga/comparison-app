package com.mediga.comparisonapp.model;

public class FeatureValueWrapper {
    private Feature feature;
    private String value;

    public FeatureValueWrapper() {
    }

    public FeatureValueWrapper(Feature feature, String value) {
        this.feature = feature;
        this.value = value;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
