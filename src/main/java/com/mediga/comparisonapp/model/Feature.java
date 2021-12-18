package com.mediga.comparisonapp.model;

public class Feature {
    private Integer id;
    private String featureName;
    private FeatureCategory featureCategory;

    public Feature() {
    }

    public Feature(Integer id, String featureName, FeatureCategory featureCategory) {
        this.id = id;
        this.featureName = featureName;
        this.featureCategory = featureCategory;
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

    public FeatureCategory getFeatureCategory() {
        return featureCategory;
    }

    public void setFeatureCategory(FeatureCategory featureCategory) {
        this.featureCategory = featureCategory;
    }
}
