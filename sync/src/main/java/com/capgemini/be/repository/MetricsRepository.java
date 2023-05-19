package com.capgemini.be.repository;

import com.capgemini.be.lms.model.LeaveType;
import com.capgemini.be.model.MetricsEntry;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class MetricsRepository {
    private final List<MetricsEntry> metricsCollection;

    public MetricsRepository() {
        metricsCollection = new ArrayList<>();
        metricsCollection.add(new MetricsEntry("John Doe", LocalDate.parse("2023-05-10"), LocalDate.parse("2023-05-12"), LeaveType.VACATION, 24));
        metricsCollection.add(new MetricsEntry("Jane Smith", LocalDate.parse("2023-05-11"), LocalDate.parse("2023-05-13"), LeaveType.PARENTAL, 16));
    }

    public List<MetricsEntry> getAllEntries() {
        return new ArrayList<>(metricsCollection);
    }
}
