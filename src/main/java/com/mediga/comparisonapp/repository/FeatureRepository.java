package com.mediga.comparisonapp.repository;

import com.mediga.comparisonapp.model.Feature;
import com.mediga.comparisonapp.model.FeatureCategory;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FeatureRepository {
    private List<Feature> features;

    public FeatureRepository() {
        this.features = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        try {
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("feature_data.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            //Skip Headers
            String line = reader.readLine();
            int id = 1;
            while((line = reader.readLine()) != null) {
                String data[] = line.split(",");
                if(data.length >= 2) {
                    FeatureCategory featureCategory = FeatureCategory.valueOf(data[1].toUpperCase());
                    Feature feature = new Feature(id, data[0], featureCategory);
                    features.add(feature);
                    id++;
                }
            }
        } catch (Exception e) {
            System.out.println("Couldn't initialize feature data");
        }
    }

    public List<Feature> getFeatures() {
        return features;
    }
}
