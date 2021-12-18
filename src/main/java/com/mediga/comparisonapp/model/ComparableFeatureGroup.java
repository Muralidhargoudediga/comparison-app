package com.mediga.comparisonapp.model;

import java.util.ArrayList;
import java.util.List;

public class ComparableFeatureGroup {
    private List<ComparableFeature> featureList;
    private FeatureCategory featureCategory;

    public ComparableFeatureGroup() {
        this.featureList = new ArrayList<>();
    }

    public ComparableFeatureGroup(List<ComparableFeature> featureList, FeatureCategory featureCategory) {
        this.featureList = featureList;
        this.featureCategory = featureCategory;
    }

    public List<ComparableFeature> getFeatureList() {
        return featureList;
    }

    public void setFeatureList(List<ComparableFeature> featureList) {
        this.featureList = featureList;
    }

    public FeatureCategory getFeatureCategory() {
        return featureCategory;
    }

    public void setFeatureCategory(FeatureCategory featureCategory) {
        this.featureCategory = featureCategory;
    }
}
