package com.capgemini.be.repository;

import com.capgemini.be.model.MetricsEntry;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class MetricsRepository {
    private List<MetricsEntry> metricsCollection;

    public MetricsRepository() {
        metricsCollection = new ArrayList<>();
    }

    public void addEntry(MetricsEntry entry) {
        metricsCollection.add(entry);
    }

    public List<MetricsEntry> getAllEntries() {
        return new ArrayList<>(metricsCollection);
    }
}
